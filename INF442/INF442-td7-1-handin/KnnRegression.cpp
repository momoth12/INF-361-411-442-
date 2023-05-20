
#include "KnnRegression.hpp"
#include<iostream>
#include <ANN/ANN.h>


KnnRegression::KnnRegression(int k, Dataset* dataset, int col_regr)
: Regression(dataset, col_regr) {
	m_k = k;
 	// TODO Exercise 5
	m_k=k;
    int dim=dataset->GetDim();
    int n=dataset->GetNbrSamples();
    m_dataPts=annAllocPts(n,dim-1);
    for(int i=0;i<n;i++){ 
        for(int j=0;j<col_regr;j++){
            m_dataPts[i][j]=dataset->GetInstance(i)[j];}
        for(int j=col_regr+1;j<dim;j++){
            m_dataPts[i][j-1]=dataset->GetInstance(i)[j];}
    }        
    m_kdTree = new ANNkd_tree(m_dataPts,n,dim-1);
}

KnnRegression::~KnnRegression() {
	// TODO Exercise 5
	annDeallocPts(m_dataPts);
    delete m_kdTree;
}

double KnnRegression::Estimate(const Eigen::VectorXd & x) const {
	assert(x.size()==m_dataset->GetDim()-1);
	// TODO Exercise 6
	ANNpoint requete=annAllocPt(x.size());
	for(int i=0;i<x.size();i++){
		requete[i]=x[i];
	}

	ANNdistArray distances=new ANNdist[m_k];
    ANNidxArray indexes=new ANNidx[m_k];
    
    m_kdTree->annkSearch(requete,m_k,indexes,distances);//creation of the tree pas de threshold
	double sum=0;
    
    for (int i = 0; i < m_k; i++)
    {
        double add=m_dataset->GetInstance(indexes[i])[m_col_regr];
        sum+=add;
    }
    sum=sum/m_k;
	delete distances;
	delete indexes;
	return sum;
}

int KnnRegression::GetK() const {
	return m_k;
}

ANNkd_tree* KnnRegression::GetKdTree() const {
	return m_kdTree;
}
