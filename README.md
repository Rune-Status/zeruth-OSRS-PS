# OSRS-PS


OSRS-PS is an open source Old School Runescape Revision 176 private server / RuneLite Client.

# Prerequisites

  - IntelliJ IDEA
  - MySQL Installer https://dev.mysql.com/downloads/installer/
  - MySQL Workbench (Optional but HIGHLY recommended) https://dev.mysql.com/downloads/workbench/


# Setup
  First you are going to want to import the project in IDEA.
  You can compile the server and client without SQL setup but the server won't run without it.
  
  After you have MySQL setup, you need to initialize your database using the Workbench.
  (Note that default settings until now work just fine)
 
  Inside the workbench, in the navigator pane, at the bottom select schemas
  In that pane, right click > Create Schema
  
  You can name the schema whatecer you want, but be sure to make it memorable, you need the name for the servers configuration. After you are done, right click the schema you just made and set it as default.
  
  Go to File > Open SQL Script
  
  Navigate to the root of this project, and open wrenc_server_rsps. This will take a few moments to load.
  
 Execute the script by clicking the first lightning icon on the toolbar. This will take a while.
 
 After that is done it is time to move on to the servers SQL configuration.
 Navigate to org.arcanium.game.system.mysql.SQLManager
 
Change DATABASE_URL to be "localhost:3306/world1" where 3306 is the (default port) & world1 is the name of the schema you used earlier.
change USERNAME to root
change PASSWORD to whatever password you chose for MYSQL

At this point you should be able to start the server, run the shaded jar (or compile RL yourself) and be able to login using the following test account:
user: testusername
pass: xojaiyfa
  
  
  # Credits
  First of all thanks to everyone who believes in open source. It's the way to be,
  
    Vashmeed - Released the original source which this is based off of. Incredible work.
    Adam & the RuneLite team - They really make the world a better place.
    Polar - Could not have done it without all his help. Really great guy and I'm lucky to be able to have him as a resource.
    Kris - Great guy. Incredibly knowledgable and willing to help a ton if you can show you're willing to learn.
    Inferno Team
    Arios Team
    Klem3n
    Zion
    Nomac
    Displee
    Bart
    IlluZive (original Arios web design)
