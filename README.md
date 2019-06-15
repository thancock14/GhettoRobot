GhettoRobot

This program was made to run two different nxj lego machines simultaneously.
It is written in Java and uses a lejos package in the nxj api called lejos.robotics.subsumtion
Here is the link:  
	http://lejos.sourceforge.net/nxt/nxj/api/lejos/robotics/subsumption/package-summary.html

It also uses javax.bluetooth to connect the two machines together.

ghettoBot.nxj and MyBTreceiver.nxj are the two executables that were finally uploaded 
to the two machines to be ran.
They were compiled from ghettoBot.java and MyBTreceiver.java which take advantage of 
subsumption to prioritize different actions and behaviors that the robot performed
based on inputs.

The difficult part was synchronizing the two robots to run simultaneously, because one
controlled a set of wheels and motors and the other controlled another set of wheels
and motors.  After a few trials and errors I found the average delay time and it 
ran rather smoothly.

Written by Terence Hancock