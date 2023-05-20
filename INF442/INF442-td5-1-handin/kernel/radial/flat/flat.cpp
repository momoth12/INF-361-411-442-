#include <cmath> // for pow, atan, should you need them

#include <point.hpp>
#include <flat.hpp>

// TODO 2.1.1: implement volume and profile
// HINT: pi = std::atan(1) * 4.0
double flat::volume() const {
	return (pow(std::atan(1) * 4.0,point::get_dim()/2) / std::tgamma(1.00+ point::get_dim()/2));
}

double flat::profile(double t) const {
	if(t<=1) return 1.0;
	else{
		return 0;
	}
}
