package org.arcanium.net.event;

import lombok.val;
import org.arcanium.NetworkConstants;
import org.arcanium.cache.Cache;
import org.arcanium.cache.crypto.ISAACCipher;
import org.arcanium.cache.crypto.ISAACPair;
import org.arcanium.cache.crypto.XTEACryption;
import org.arcanium.cache.misc.buffer.ByteBufferUtils;
import org.arcanium.game.node.entity.player.info.ClientInfo;
import org.arcanium.game.node.entity.player.info.PlayerDetails;
import org.arcanium.game.node.entity.player.info.UIDInfo;
import org.arcanium.game.node.entity.player.info.login.LoginParser;
import org.arcanium.game.node.entity.player.info.login.LoginType;
import org.arcanium.game.node.entity.player.info.login.Response;
import org.arcanium.game.node.entity.player.info.portal.PlayerSQLManager;
import org.arcanium.game.system.task.TaskExecutor;
import org.arcanium.net.IoReadEvent;
import org.arcanium.net.IoSession;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.sql.SQLException;

/**
 * Handles login reading events.
 *
 * @author Emperor
 */
public final class LoginReadEvent extends IoReadEvent {

    /**
     * The RSA modulus.
     */
    public static final BigInteger MODULUS = new BigInteger("165865706435016682110653568563251120094278686912987295809145491806194715902716739338411927793058925228087565434562948389222225588420069703784252638483569608159614392485969864899137973999614056797405232846059198315441808544524190866210655169682670028293787208173603935453834899795395794572295868565624049196373");
    /**
     * The RSA exponent.
     */
    public static final BigInteger RSA_KEY = new BigInteger("56600403721755849042871300293705052867669386058593586576677751174965876168398876338011266203274025417717477354449635744336265820214938719432244777866648612856409222657603092909839244312101542583618644127794582316068916809421286289618425813349038287935817476491851970456260849477664967448547154113206350117073");

    /**
     * Constructs a new {@code LoginReadEvent}.
     *
     * @param session The session.
     * @param buffer  The buffer with data to read from.
     */
    public LoginReadEvent(IoSession session, ByteBuffer buffer) {
        super(session, buffer);
    }

    @Override
    public void read(IoSession session, ByteBuffer buffer) {
        int opcode = buffer.get() & 0xFF;
        /**
         * Session ID
         */
        if ((buffer.getShort()) != buffer.remaining()) {
            session.write(Response.BAD_SESSION_ID);
            return;
        }
        /**
         * Game Revision
         */
        if (buffer.getInt() != NetworkConstants.REVISION) {
            session.write(Response.UPDATED);
            return;
        }
        val subBuild = buffer.getInt();
        val new2 = buffer.get();
        switch (opcode) {
            case 16: // Reconnect world login
            case 18: // World login
                decodeWorld(opcode, session, buffer);
                break;
            default:
                System.err.println("[Login] Unhandled login type [opcode=" + opcode + "]!");
                session.disconnect();
                break;
        }
    }

    /**
     * Decodes a world login request.
     *
     * @param session The session.
     * @param buffer  The buffer to read from.
     */
    private static void decodeWorld(final int opcode, final IoSession session, ByteBuffer buffer) {
        ByteBuffer rsa_buffer = getRSABlock(buffer);
        int[] isaacSeed = getISAACSeed(rsa_buffer);
        long var1 = rsa_buffer.getLong();
        int auth_type = rsa_buffer.get();

        switch (auth_type) {
            case 0:
            case 3:
                int code = ByteBufferUtils.getTriByte(rsa_buffer);
                rsa_buffer.position(rsa_buffer.position() + 1);
                break;
            case 1:
                rsa_buffer.position(rsa_buffer.position() + 4);
                break;
            case 2:
                rsa_buffer.getInt();
                break;
        }
        int var2 = rsa_buffer.get();
        final String password = ByteBufferUtils.getString(rsa_buffer);
        ByteBuffer isaacBuffer = XTEACryption.decrypt(buffer, isaacSeed);
        final String username = ByteBufferUtils.getString(isaacBuffer);
        //int info = ForumIntegration.validate(username, password);
        //final PlayerDetails details = new PlayerDetails(username, null, session);
        int displaySetting = isaacBuffer.get();
        int windowMode = (displaySetting >> 1);
        boolean lowMem = (displaySetting & 0xFF) == 1;
        int width = isaacBuffer.getShort();
        int height = isaacBuffer.getShort();
        isaacBuffer.position(isaacBuffer.position() + 24);
        String sessionToken1 = ByteBufferUtils.getString(isaacBuffer);
        int affiliateID = isaacBuffer.getInt();
        isaacBuffer.get(); // machine info opcode 6
        isaacBuffer.get(); // os type
        isaacBuffer.get(); // 64 bit
        isaacBuffer.get(); // os version
        isaacBuffer.get(); // vendor
        isaacBuffer.get(); // major
        isaacBuffer.get(); // minor
        isaacBuffer.get(); // patchcant type anything
        isaacBuffer.get(); // some flag
        isaacBuffer.getShort(); // max memory
        isaacBuffer.get();
        isaacBuffer.get();
        isaacBuffer.getShort();
        isaacBuffer.getShort();
        ByteBufferUtils.getJagString(isaacBuffer);
        ByteBufferUtils.getJagString(isaacBuffer);
        ByteBufferUtils.getJagString(isaacBuffer);
        ByteBufferUtils.getJagString(isaacBuffer);
        isaacBuffer.get();
        isaacBuffer.getShort();
        ByteBufferUtils.getJagString(isaacBuffer);
        ByteBufferUtils.getJagString(isaacBuffer);
        isaacBuffer.get();
        isaacBuffer.get();
        isaacBuffer.getInt();
        isaacBuffer.getInt();
        isaacBuffer.getInt();
        isaacBuffer.getInt();
        int sessionToken2 = isaacBuffer.get();
        isaacBuffer.getShort(); //mobile OS
        int crcBlock = isaacBuffer.getInt();
        final int[] clientCRC = new int[18];
        final int[] serverCRC = new int[18];
        for (int i = 0; i < 18; i++) {
            clientCRC[i] = isaacBuffer.getInt();
            serverCRC[i] = Cache.getIndexes()[i] == null ? 0 : Cache.getIndexes()[i].getInformation().getInformationContainer().getCrc();
        }
        ISAACCipher inCipher = new ISAACCipher(isaacSeed);
        for (int i = 0; i < 4; i++) {
            isaacSeed[i] += 50;
        }
        ISAACCipher outCipher = new ISAACCipher(isaacSeed);
        session.setIsaacPair(new ISAACPair(inCipher, outCipher));

        final PlayerDetails details = new PlayerDetails(username, password, session);
        details.setClientInfo(new ClientInfo(windowMode, width, height));
        final ByteBuffer b = isaacBuffer;

        TaskExecutor.executeSQL(() -> {
            try {
                Response response = PlayerSQLManager.getCredentialResponse(details, username, password);
                if (response != Response.SUCCESSFUL) {
                    session.write(response, true);
                    return;
                }
                login(details, username, password, session, b, opcode);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Handles the login procedure after we check an acc is registered.
     *
     * @param username the username.
     * @param password the password.
     * @param session  the session.
     * @param buffer   the byte buffer.
     * @param opcode   the opcode.
     */
    private static void login(final PlayerDetails details, String username, String password, IoSession session, ByteBuffer buffer, int opcode) {
        val parser = new LoginParser(details, password, new UIDInfo(session.getAddress(), "none", "none", "none"), LoginType.fromType(opcode));
        TaskExecutor.executeSQL(parser);
    }

    /**
     * Gets the ISAAC seed from the buffer.
     *
     * @param buffer The buffer to read from.
     * @return The ISAAC seed.
     */
    public static int[] getISAACSeed(ByteBuffer buffer) {
        int[] seed = new int[4];
        for (int i = 0; i < 4; i++) {
            seed[i] = buffer.getInt();
        }
        return seed;
    }

    /**
     * Gets the RSA block buffer.
     *
     * @param buffer The buffer to get the RSA block from.
     * @return The RSA block buffer.
     */
    public static ByteBuffer getRSABlock(ByteBuffer buffer) {
        byte[] rsaData = new byte[buffer.getShort()];
        buffer.get(rsaData);
        ByteBuffer block = ByteBuffer.wrap(new BigInteger(rsaData).modPow(RSA_KEY, MODULUS).toByteArray());
        int num = block.get();
        if (num != 1) {
            throw new IllegalArgumentException("Invalid RSA Magic Number " + num + "!");
        }
        return block;
    }

}