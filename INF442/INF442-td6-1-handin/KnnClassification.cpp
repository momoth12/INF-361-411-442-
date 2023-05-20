
#include "KnnClassification.hpp"
#include <iostream>
#include <ANN/ANN.h>


KnnClassification::KnnClassification(int k, Dataset *dataset, int col_class)
: Classification(dataset, col_class) {
    // TODO Exercise 1
    m_k=k;
    int dim=dataset->getDim();
    int n=dataset->getNbrSamples();
    m_dataPts=annAllocPts(n,dim-1);
    for(int i=0;i<n;i++){ 
        for(int j=0;j<col_class;j++){
            m_dataPts[i][j]=dataset->getInstance(i)[j];}
        for(int j=col_class+1;j<dim;j++){
            m_dataPts[i][j-1]=dataset->getInstance(i)[j];}
    }        
    m_kdTree = new ANNkd_tree(m_dataPts,n,dim-1);
}
KnnClassification::~KnnClassification() {
    // TODO Exercise 1
    annDeallocPts(m_dataPts);
    delete m_kdTree;
    
}

int KnnClassification::Estimate(const ANNpoint &x, double threshold) const {
    // TODO Exercise 2
    ANNdistArray distances=new ANNdist[m_k];
    ANNidxArray indexes=new ANNidx[m_k];
    
    m_kdTree->annkSearch(x,m_k,indexes,distances,threshold);//creation of the tree
    double sum=0;
    
    for (int i = 0; i < m_k; i++)
    {
        double add=m_dataset->getInstance(indexes[i])[m_col_class];
        sum+=add;
    }
    sum=sum/m_k;
    if(sum<=threshold){
        return 0;
    
    }
    else{
        return 1;
    }
    
}

int KnnClassification::getK() const {
    return m_k;
}

ANNkd_tree *KnnClassification::getKdTree() {
    return m_kdTree;
}
