#include "LinearRegression.hpp"
#include "Dataset.hpp"
#include "Regression.hpp"
#include<iostream>
#include<cassert>


LinearRegression::LinearRegression( Dataset* dataset, int col_regr ) 
: Regression(dataset, col_regr) {
	m_beta = NULL;
	SetCoefficients();
}

LinearRegression::~LinearRegression() {
	if (m_beta != NULL) {
		m_beta->resize(0);
		delete m_beta;
	}
}


Eigen::MatrixXd LinearRegression::ConstructMatrix() {
	// TODO Exercise 1
	int dim=m_dataset->GetDim();
	int n=m_dataset->GetNbrSamples();
	Eigen::MatrixXd X(n,dim);
	
	X.col(0).setOnes(); //initialisation premiere colonne
	for(int i=0;i<n;i++){
		for(int j=0;j<dim;j++){
			if(j>m_col_regr){
				X(i,j)=m_dataset->GetInstance(i)[j]; //Apres la colonne de regression
			}
			if(j<m_col_regr){
				X(i,j+1)=m_dataset->GetInstance(i)[j];// Avant la colonne de regression prendre en compte la colonne premiere
			}
		}
	}


	// replace this command with what you compute as a matrix X
	return X;
}

Eigen::VectorXd LinearRegression::ConstructY() {
	// TODO Exercise 1

	// replace this command with what you compute as a vector y.
	int n=m_dataset->GetNbrSamples();
	Eigen::VectorXd y(n);
	//initialisation
	for(int i=0;i<n;i++){
		y(i)=m_dataset->GetInstance(i)[m_col_regr];
	}


	return y;
}

void LinearRegression::SetCoefficients() {
	// TODO Exercise 2
	Eigen::MatrixXd  A= ConstructMatrix();
	Eigen::VectorXd y=ConstructY();
	m_beta=new Eigen::VectorXd(A.cols());
	*m_beta=(A.transpose()*A).ldlt().solve(A.transpose()*y);

}

const Eigen::VectorXd* LinearRegression::GetCoefficients() const {
	if (!m_beta) {
		std::cout<<"Coefficients have not been allocated."<<std::endl;
		return NULL;
	}
	return m_beta;
}

void LinearRegression::ShowCoefficients() const {
	if (!m_beta) {
		std::cout<<"Coefficients have not been allocated."<<std::endl;
		return;
	}
	
	if (m_beta->size() != m_dataset->GetDim()) {  // ( beta_0 beta_1 ... beta_{d} )
		std::cout<< "Warning, unexpected size of coefficients vector: " << m_beta->size() << std::endl;
	}
	
	std::cout<< "beta = (";
	for (int i=0; i<m_beta->size(); i++) {
		std::cout<< " " << (*m_beta)[i];
	}
	std::cout << " )"<<std::endl;
}

void LinearRegression::PrintRawCoefficients() const {
	std::cout<< "{ ";
	for (int i=0; i<m_beta->size()-1; i++) {
		std::cout<< (*m_beta)[i]  << ", ";
	}
	std::cout << (*m_beta)[m_beta->size()-1];
	std::cout << " }"<<std::endl;
}

void LinearRegression::SumsOfSquares( Dataset* dataset, double& ess, double& rss, double& tss ) const {
	assert(dataset->GetDim()==m_dataset->GetDim());
	// TODO Exercise 4
	LinearRegression LR(dataset,m_col_regr); //Initialisation du classifier
	Eigen::MatrixXd X=LR.ConstructMatrix();
	Eigen::VectorXd y=LR.ConstructY();
	int n=dataset->GetNbrSamples();
	//Calcul de la prediction
	Eigen::VectorXd beta_hat=m_beta->transpose();
	Eigen::VectorXd pred(n);
	pred=X*beta_hat;
	//Calcul du ESS

	double y_bar=y.mean();
	double essp=0.0;
	for(int i=0;i<n;i++){
		ess+=pow(pred[i]-y_bar,2);
	}
	ess=essp;

	//Calcul du RSS
	double rssp=0.0;
	for(int i=0;i<n;i++){
		rssp+=pow(pred[i]-y[i],2);
	}
	rss=rssp;
	//Calcul du TSS
	tss=ess+rss;
	return;
	



}

double LinearRegression::Estimate( const Eigen::VectorXd & x ) const {
	// TODO Exercise 3
	Eigen::VectorXd merge(1+x.size());
	merge <<1,x;
	Eigen::VectorXd beta= m_beta->transpose();
	double result=beta.dot(merge);
	return result;

}
