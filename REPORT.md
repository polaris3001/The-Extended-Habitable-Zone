# The Extended Habitable Zone
## By Xenia Beltei
### Section 3: Introduction to Computer Programming in Engineering and Science
#### May 2019

## Introduction
For my CE, I decided to explore the idea of the habitable zone even further. 
For the term project, Susan and I wrote a program that would show the stability of the planet’s orbit around a binary star system. 
In the report we discussed how the stability has a big impact on the habitability of the planet. 
However, there are many other factors that can influence this. One of them is the amount of starlight that a 
planet receives from its star. If the planet is located too close, the star will make the water evaporate, 
which is not unsuitable the habitability of a planet, as it relies among other factors on liquid water. If a planet will be too far, the water is going to be frozen, which is also bad. It's even more complicated
when you think about a binary star system because we have to take into account the radiation from both stars which will be located at different
positions every single instance of time, so the total amount of the radiation received on the planet will vary.
In my CE I will write a program that will take values(stars' radii, the distance from the planet to the stars) as input and 
will predict the extended habitable zone for a particular system. I will explore both types of systems, the ones that have one star at the center and the binary star systems.

I will validate my code by running it with the values of planets within the habitable zone that we already know 
(for example planets like TRAPPIST-1d, Kepler-186f, Kepler-442b). 

## The Model and the Code
The goal of my program is to print values for the inner and the outer adge of the extended habitable zone. The extended habitable zone is larger than the conservative habitable zone (it includes distances with less favourable conditions basically).
In my model, I assume circular orbits.
The first equation that we need is the absolute luminosity equation:

![alt text](https://github.com/polaris3001/The-Extended-Habitable-Zone/blob/main/1.png)


In this equation, L is the absoulute luminosity of the Sun in Watts, the R is the radius of the star in meters and the T is the temperature in kelvins. The sigma is the Stefan–Boltzmann constant (5.67E-8 W/m^2*K^4).

The next equation is the received Intensity equation:

![alt text](https://github.com/polaris3001/The-Extended-Habitable-Zone/blob/main/2.png)

In this equation I is the intensity of the received starlight in W/m^2, the L is the absolute luminosity of the star in Watts, the r is the distance between the planet and the star. 

Also, I took into account the estimation of the Sun's habitable zone. The most recent one was done by Ramirez and Kaltenegger in 2017.
They found that the inner edge of the HZ of the Sun is 0.95 AU and the outer edge is 2.4 AU.

In order to find the habitable zone for an exoplanet, we can use the extrasolar extrapolation. Basically it means that:

![alt text](https://github.com/polaris3001/The-Extended-Habitable-Zone/blob/main/3.png)

With the same logic, I can use the ratio to find not only the center of the HZ, but the edge values too.

Now I will explain how the habitable zone boundaries will be calculated in both cases.

##### Case 1:

First, the program will calculate the star's luminosity with the absolute luminosity equation. 
Because the orbit is circular, the distance from the planet to the star is constant,
so we will need to calculate the star's luminosity only once. From there, we will need to calculate the intensity of the radiation 
received by the planet. I also decided to report it relative to the intensity of the sunlight received on Earth. Reason why I do this is because 
I will evaluate how much starlight does a planet receive compared to the Sun-Earth situation. In the end, the output will consist of 2 numbers that will be the inner and the outer edge of the HZ of the star in question. It will also state if the planet in the problem is hotter or cooler than the Earth by comparing the amount of the intensity received on the planet by its host star.

##### Case 2:

The second case is similar to the first case in the absolute luminosity calculation. Although for this time, the abs.luminosity is calculated twice, for the star 1 and the star 2. Then the values are added together and divided by the absolute luminosity of the Sun to make them relative to it. Then the extrasolar extrapolation is used to find out the inner and outer edges of the HZ of the binary star system. 
The binary star systems are not yet fully understood by the scientists, many questions remain unanswered. When I did my research, I found out that scientists believe that the smaller the separation between the orbits of the two stars is, the more stable the orbits will be. Which is very similar to what I found out with my collegue Susan, when we were doing the Three-Body Problem simulation. So for this case, I set up the following values for the system that cannot be changed by the user during the runtime of the program:
			
			double xplan0 = 0; 
			double xstarone0 = -0.15;  
			double xstartwo0 = 0.15; 
			double radiusPlanet = 1; 
			double radStar1 = 0.1;
			double radStar2 = 0.1;

All the distances are in AU. I used the same logic as in the Three-Body Problem to determine the initial x-positions of the bodies.
In the end, the output consists of 2 numbers that will be the inner and the outer edge of the HZ of the stars in question.

## Results

The code validation was performed by calculating the the size of the habitable zones of the following 4 planets: TRAPPIST-1d, Kepler-186f and Kepler-442b.

#### TRAPPIST-1d

For this case, we need to imput the following values:

Radius of the star(meters): 84 252 300

Temperature of the star(K): 2 511

The distance of the semi-major axis(the distance from the planet to the star, in meters): 3 333 144 848

For this configuration, the program's output is:

`For a star with a radius of 8.42523E7 meters and a planet orbiting around it at a distance of 3.333144848E9 meters the extended habitable zone of the star is between 0.021766864345515294AU and 0.054989973083407064AU. The planet will be hotter than the Earth. It receives 105.75763651896462% of starlight that Earth receives from the Sun.`

From my research I found out that TRAPPIST-1d "receives just 4.3% more sunlight than Earth". In my simulation, it receives 5.76% more starlight, which makes the percent error of only 34%. Also, the scientists think that the HZ of the star TRAPPIST is located somewhere between the orbit of the planet TRAPPIST-1 c (semi-major axis: 0.0152±0.0005 AU) and the planet TRAPPIST-1 h(semi-major axis: 0.0596 AU).

The percent error for the inner edge is: 43%

The percent error for the outer edge is: 7.7%

#### Kepler-186f

For this case, we need to imput the following values:

Radius of the star: 364 164 900

Temperature of the star: 3 755

The distance of the semi-major axis(the distance from the planet to the star): 6.46272E10

For this configuration, the program's output is:

`For a star with a radius of 3.641649E8 meters and a planet orbiting around it at a distance of 6.46272E10 meters the extended habitable zone of the star is between 0.2103965656651442AU and 0.5315281658908906AU. The planet will be cooler than the Earth. It receives 26.28300282964695% of starlight that Earth receives from the Sun.`

Scientists estimate that Kepler-186f receives about 32% of the starlight that Earth receives from the Sun. This means that for this value, I have a 17.8% of error. The HZ is estimated to be from 0.23 to 0.46 AU.

The percent error for the inner edge is: 8.5%

The percent error for the outer edge is: 15.65%

#### Kepler-442b

For this case, we need to imput the following values:

Radius of the star: 417 780 000

Temperature of the star: 4 402

The distance of the semi-major axis(the distance from the planet to the star): 6.11864E10

For this configuration, the program's output is:

`For a star with a radius of 4.1778E8 meters and a planet orbiting around it at a distance of 6.11864E10 meters the extended habitable zone of the star is between 0.3317175138311438AU and 0.8380231928365738AU. The planet will be cooler than the Earth. It receives 72.88788861696244% of starlight that Earth receives from the Sun.`

Scientists say that "Kepler-442b receives about 70% of the sunlight that Earth receives from the Sun". Which means that the percent error is of 4.13%. For the star Kepler-442 the values for the edges of the HZ remain unknown, but the values I got from the program make sense, as Kepler-442b resides inside them(at 0.409AU).

#### Binary Star System Case
After I made sure that my code is validated, I tested it against a binary star system. 

For this case, we need to imput the following values:

Radius of the star1: 6.963E8

Radius of the star2: 6.963E8

Temperature of the star1: 2900

Temperature of the star2: 2900

`For stars with a radius of 6.963E8meters for star 1 and 6.963E8meters for star 2, the extended habitable zone of the two stars is between 1.357338162942315AU and 3.429064832696375AU.`

The scientists have predicted that for a binary star systems, the HZ will be 40% wider than for the one star systems. I picked for both stars the Sun's radius and the Sun's temperature. If I substract 2.4-0.95 (the edges of the Sun's HZ), I obtain 1.45AU. If I substract 3.429-1.357, I get 2.072AU. The ratio of the two sizes of HZ is roughly 70% which is bigger than what the scientists have predicted.

## Discussion 

#### Precision
Overall, I succeeded at creating a program that calculates the inner and the outer edges of the habitable zone of a star or a binary star system. When you look at the percent errors I got for every run, it is good except for the TRAPPIST-1d, where the percent exceeds 20%. This is because I made approximations. For example, I assumed circular orbits, which is not the case. The planets orbit around the stars in ellipses and they have their closest and farthest approach (apastron and periastron). This means that the starlight travels different distances (which is not the case in the circular orbits, because the distance i.e. radius always remains the same). The values differ also because I use extrasolar extrapolation technique. It is a very useful tool that a lot of astrophysicists use, but it is not very exact as it is based on the ratios. Another reason why my values vary from the literature ones is because the values that we know for stars and planets are not exact. For example, if you look up the temperature of the star Kepler-442, you will see that the value stated is 4402 ± 100 K, which is not exact. For all the celestial objects we know, we use approximation for their values because for now, we do not possess strong enough instruments to measure the values to a better precision.

#### Conclusion

In the term project, I explored the stability of a planet's orbit in a binary star system because it is an important factor for its habitability. In this project, I decided to go even further and see what else affects the habitability of a planet. I learned how to find the habitable zone of any kind of systems. It's a very important piece of knowledge, however there are still other factors that have a huge impact on a planet's habitability. For example, the greenhouse effect and the tidal effect. The greenhouse effect is the trapping of the star's light in a planet's atmosphere. If it is not strong enough on a planet, no matter how many light a planet receives, it won't be a good candidate for a habitable planet. The tidal effect is also very important. If a planet is tidally locked to its star, the other side of the planet will never receive starlight, it will have a very low temperature, which will make the planet uninhabitable.

## References
Redd, Nola Taylor. HABITABLE BINARY STAR SYSTEMS. _Astrobiology Magazine: Exploring Origins of Life on Earth & Beyond_, 2013.

https://www.astrobio.net/news-exclusive/habitable-binary-star-systems/

Sutter, Paul. Is Life Possible Around Binary Stars?_Space.com_, 2015.

https://www.space.com/29985-is-life-possible-around-binary-stars.html

Circumstellar habitable zone. _Wikipedia:the Free Encyclopedia_.

https://en.wikipedia.org/wiki/Circumstellar_habitable_zone

Circumstellar Habitable Zone Simulator. _Astronomy Education at the University of Nebraska-Lincoln_.

http://astro.unl.edu/naap/habitablezones/animations/stellarHabitableZone.html

Habitable Exoplanet Catalog. _Planetary Habitability Laboratory of the University of Puerto Rico at Arecibo_, 2019.

http://phl.upr.edu/projects/habitable-exoplanets-catalog

Prantzos, Nikos. On the "Galactic Habitable Zone". _Institut d'Astrophysique de Paris_, 2006.

https://arxiv.org/pdf/astro-ph/0612316.pdf
