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
