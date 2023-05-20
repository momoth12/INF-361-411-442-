#include <cmath> // for pow, atan, should you need them
#include <iostream> // for cerr

#include <point.hpp>
#include <cloud.hpp>
#include <gaussian.hpp>

// TODO 2.1.2: implement volume, profile and guess_bandwidth
// HINTS: pi = std::atan(1) * 4.0, e^x is std::exp(x)
double gaussian::volume() const {
	return 2*pow((std::atan(1) * 4.0),point::get_dim()/2);
}

double gaussian::profile(double t) const {
	return std::exp((-1)*t/2);
}

void gaussian::guess_bandwidth() {
}
