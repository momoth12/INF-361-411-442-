#include "ConfusionMatrix.hpp"
#include <iostream>

using namespace std;

ConfusionMatrix::ConfusionMatrix() {
    // TODO Exercise 3
    // Populate 2x2 matrix with 0s
}

ConfusionMatrix::~ConfusionMatrix() {
    // Attribute m_confusion_matrix is deleted automatically
    m_confusion_matrix[0][0]=0;
    m_confusion_matrix[1][1]=0;
    m_confusion_matrix[1][0]=0;
    m_confusion_matrix[0][1]=0;
}

void ConfusionMatrix::AddPrediction(int true_label, int predicted_label) {
    // TODO Exercise 3
    m_confusion_matrix[true_label][predicted_label]+=1;
}

void ConfusionMatrix::PrintEvaluation() const{
    // Prints the confusion matrix
    cout <<"\t\tPredicted\n";
    cout <<"\t\t0\t1\n";
    cout <<"Actual\t0\t"
        <<GetTN() <<"\t"
        <<GetFP() <<endl;
    cout <<"\t1\t"
        <<GetFN() <<"\t"
        <<GetTP() <<endl <<endl;
    // Prints the estimators
    cout <<"Error rate\t\t"
        <<error_rate() <<endl;
    cout <<"False alarm rate\t"
        <<false_alarm_rate() <<endl;
    cout <<"Detection rate\t\t"
        <<detection_rate() <<endl;
    cout <<"F-score\t\t\t"
        <<f_score() <<endl;
    cout <<"Precision\t\t"
        <<precision() <<endl;
}

int ConfusionMatrix::GetTP() const {
    return m_confusion_matrix[1][1];
}

int ConfusionMatrix::GetTN() const {
   return m_confusion_matrix[0][0];
}

int ConfusionMatrix::GetFP() const {
    return m_confusion_matrix[0][1];
}

int ConfusionMatrix::GetFN() const {
   return m_confusion_matrix[1][0];
}

double ConfusionMatrix::f_score() const {
    // TODO Exercise 3
    double a=2*precision()*detection_rate();
    double b=precision()+detection_rate();
    return a/b;
}

double ConfusionMatrix::precision() const {
    // TODO Exercise 3
    double a=GetTP();
    double b=GetTP()+GetFP();
    return a/b;

}

double ConfusionMatrix::error_rate() const {
    // TODO Exercise 3
    double a=GetFP()+GetFN();
    double b=GetFP()+GetFN()+GetTP()+GetTN();
    return a/b;
}

double ConfusionMatrix::detection_rate() const {
    // TODO Exercise 3
    double a=GetTP();
    double b=GetTP()+GetFN();
    return a/b;
}

double ConfusionMatrix::false_alarm_rate() const {
    // TODO Exercise 3
    double a=GetFP();
    double b=GetFP()+GetTN();
    return GetFP()/b;

}
