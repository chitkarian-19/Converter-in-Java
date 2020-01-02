# Converter-in-Java
This is a converter which converts several quantities like numbers ,mass ,length etc. 

Minimum features of System required to run the program
1. 32-BIT Architecture 
2. 4 GB RAM
3. JDK(1.8)
4. Eclipse(Neon)
5. Xampp/mysql Server

Try to run it on eclipse(neon) because it supports the "Window Builer" feature and to avoid any issues .Do save all the data in the database before running it otherwise only you would be able to see the GUI only and only number conversion would be posssible . The whole application is built in Java Swing FrameWork along with JDBC connectivity.

However if any error comes do consult "you-tube" or mail me.

Here i am telling how to make the table and 

                         The name of the database should be "project"
	
	You need to make the table for every quantity except number and temperature. Here i am giving the tables for your ease
	
	1:Table name:Mass
	           Mass       | Value        |
               ------------+--------------+
                Kilogram   |            1 |
                grams      |        0.001 |
                milligrams |     0.000001 |
                microgram  | 0.0000000001 |
                tonne      |         1000 |
                pound      |       0.4535 |
                carat      |       0.0002 |
               ------------+--------------+
	2:Table name:Angle
	           +---------------+--------------------+
                | Angle         | Value              |
                +---------------+--------------------+
                | Gradian       |                0.9 |
                | Miliradian    |          0.0572958 |
                | Minute of Arc | 0.0166666726260573 |
                | Radian        |            57.2958 |
                | Second of Arc |        0.000277778 |
                | Degree        |                  1 |
                +---------------+--------------------+
	
	3.Table name:Area
	        +-------------------+---------+
                | Area              | Value   |
                +-------------------+---------+
                | Square Kilo meter | 1000000 |
                | Square Mile       | 2590000 |
                | Hectare           |   10000 |
                | Acre              | 4046.86 |
                | Square meter      |       1 |
                +-------------------+---------+ 
				 
	4.Table Name:Energy
	            
	         +--------------+-----------+
                 | Energy       | Value     |
                 +--------------+-----------+
                 | Kilojoule    |      1000 |
                 | GrameCalorie |     4.184 |
                 | KiloCalorie  |      4184 |
                 | Watthour     |      3600 |
                 | KiloWatthour |   3600000 |
                 | US Therm     | 105500000 |
                 | Joule        |         1 |
                 +--------------+-----------+
				 
	5.Table Name:Length
	            
		 +---------------+----------+
                 | LENGTH        | VALUE    |
                 +---------------+----------+
                 | Micrometre    | 0.000001 |
                 | Millimetre    |    0.001 |
                 | Centimetre    |     0.01 |
                 | Inch          |   0.0254 |
                 | Foot          |   0.3048 |
                 | Yard          |   0.9144 |
                 | Decimetre     |      0.1 |
                 | Metre         |        1 |
                 | DecaMetre     |       10 |
                 | Hectometre    |      100 |
                 | kilometre     |     1000 |
                 | Mile          |  1609.34 |
                 | Nautical Mile |     1852 |
                 +---------------+----------+
				 
	6.Table name:Pressure
	              
		  +------------+--------+
                  | Pressure   | Value  |
                  +------------+--------+
                  | Pascal     |      1 |
                  | Atmosphere | 101325 |
                  | Torr       | 133.32 |
                  | Bar        | 100000 |
		  +------------+--------+
				  
	7.Table name: Speed
	               
		   +-------+----------------+
                   | Speed | VALUE          |
                   +-------+----------------+
                   | mph   |        0.44704 |
                   | fps   |         0.3048 |
                   | kmph  |       0.277778 |
                   | knot  | 0.514444855556 |
                   | ms    |              1 |
                   +-------+----------------+
				   
	8.Table Name: Time
	           +-------------+------------------+
                   | Time        | Value            |
                   +-------------+------------------+
                   | second      |                1 |
                   | nano-second |      0.000000001 |
                   | mill-second |         0.000001 |
                   | microsecond |         0.000001 |
                   | minute      |               60 |
                   | hour        |             3600 |
                   | day         |            86400 |
                   | Week        |           604800 |
                   | Month       |          2628000 |
                   | Year        | 31535965.4396976 |
                   | Decade      | 315359654.396976 |
                   | Century     | 3153596543.96976 |
                   +-------------+------------------+
				   
	9.Table Name: volume
	               
		   +-------------+---------+
                   | Volume      | Value   |
                   +-------------+---------+
                   | Litre       |       1 |
                   | Millitre    |   0.001 |
                   | Cubic metre |    1000 |
                   | Cubic Foot  | 28.3168 |
                   +-------------+---------+
				  
	
	
    Remember you need to make the tables in the sql database in order to make the app work.				 

