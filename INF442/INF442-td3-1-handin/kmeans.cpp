#include <iostream>
#include <cassert>
#include <cmath>	// for sqrt, fabs
#include <cfloat>	// for DBL_MAX
#include <cstdlib>	// for rand, srand
#include <ctime>	// for rand seed
#include <fstream>
#include <cstdio>	// for EOF
#include <string>
#include <algorithm>	// for count
#include <vector>

using std::rand;
using std::srand;
using std::time;

class point
{
    public:

        static int d;
        double *coords;
        int label;
	point(){
		coords=new double[d];
		label=0;

	}
	void print() const{
		for (int i = 0; i < d; i++)
		{
			std::cout << coords[i] <<'\t';
		}
		
	}	
	~point(){
		delete[]coords;
	}
	double squared_dist(const point &q) const{
		double s=0;
		for(int i=0;i<d;i++){
			s+=pow((q.coords[i]-coords[i]),2);
		}
		return s;
	}
};

int point::d;


class cloud
{
	private:

	int d;
	int n;
	int k;

	// maximum possible number of points
	int nmax;

	point *points;
	point *centers;


	public:

	cloud(int _d, int _nmax, int _k)
	{
		d = _d;
		point::d = _d;
		n = 0;
		k = _k;

		nmax = _nmax;

		points = new point[nmax];
		centers = new point[k];

		srand(time(0));
	}

	~cloud()
	{
		delete[] centers;
		delete[] points;
	}

	void add_point(const point &p, int label)
	{
		for(int m = 0; m < d; m++)
		{
			points[n].coords[m] = p.coords[m];
		}

		points[n].label = label;

		n++;
	}

	int get_d() const
	{
		return d;
	}

	int get_n() const
	{
		return n;
	}

	int get_k() const
	{
		return k;
	}

	point& get_point(int i)
	{
		return points[i];
	}

	point& get_center(int j)
	{
		return centers[j];
	}

	void set_center(const point &p, int j)
	{
		for(int m = 0; m < d; m++)
			centers[j].coords[m] = p.coords[m];
	}

	double intracluster_variance() const
	{
		double var=0;
		for(int i=0;i<nmax;i++){
			var+=points[i].squared_dist(centers[points[i].label]);

		}
		return var/n;
	}

	int set_voronoi_labels()
	{

		int nbr=0;
		for (int i = 0; i < n; i++)
		{
			double dis=points[i].squared_dist(centers[points[i].label]);
			int v=points[i].label;

			for(int j=0;j<k;j++){
				if(points[i].squared_dist(centers[j])<dis){
					points[i].label=j;
				}
			}
			if (v!=points[i].label)
			{
				nbr++;
			}
			
		}
		
		return nbr;
	}

	void set_centroid_centers()
	{
		
		
	



		point*v=new point[k];
		int* tab= new int[k];
		for (int i = 0; i < k; i++)
		{
			tab[i]=0;
		}
		
		for (int i = 0; i < n; i++){
			int l=points[i].label;
			for (int j = 0; j < d; j++){
				(v+l)->coords[j]+=points[i].coords[j];
			}
			
			tab[l]++;
			
		}
		for (int i = 0; i < k; i++)
		{
			if (tab[i]>0){
				for (int j = 0; j < d; j++)
				{
					centers[i].coords[j]=(v+i)->coords[j]/tab[i];
				}
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
	}

	void init_random_partition()
	{
		for (int i = 0; i < n; i++)
		{
			int p=rand()%k;
			points[i].label=p;
		}
		set_centroid_centers();
		
	}

	void lloyd()
	{

		bool b= true;
		while (b==true)
		{
			b=false;
			set_centroid_centers();
			int k= set_voronoi_labels();
			if (k>0)
			{
				b=true;
			}
		}
		
	}

	void init_forgy()
	{
	}

	void init_plusplus()
	{
	}
};
