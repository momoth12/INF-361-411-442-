#include <cmath> // for pow, should you need it

#include <point.hpp>
#include <cloud.hpp>
#include <radial.hpp>

// TODO 2.1: density and radial constructor
// Use profile and volume... although it will only be implemented in the "sisters" classes
// Use kernel's constructor

radial::radial(cloud* data_, double bandwidth_):kernel(data_){
	bandwidth=bandwidth_;
}

double radial::density(const point& p) const
{
	double dens=0.0;
	int n=(data)->get_n();
	int dim=point::get_dim();//static method for getting the dimension
	for(int i=0;i<n;i++){
		double add=0;
		add=p.dist(data->get_point(i))/bandwidth;
		dens+=profile(pow(add,2));
	}
	return(dens*volume()/(pow(bandwidth,dim)));

}
double profile(double t){

}




