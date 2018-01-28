
# DeepLearningOnAndroid 

My First attempt at writing an article, really excited :smiley:. Check out the article accompanying this repository.
 * [Running Tensorflow models on Android](https://www.linkedin.com/pulse/running-tensorflow-models-android-explaining-basics-behind-chaudhary/)

This repository contains the material for deploying deep learning models on mobile and embedded platforms like Raspberry pi. I plan to make this a one stop tutorial series to deploy any kind of Neural Network developed on any framework like Tensorflow, Pytorch, CNTK etc.

Tutorials are created as jupyter notebooks so that instead of just reading or just seeing code at a time, you can better understand what you read while executing actual code. 

## Audience 
>This repo is for anyone who 
>* has interest in deep learning but no idea about it
>* wants to understand basics of deep learning and tensorflow
>* has some or no coding experience


***This series of tutorials cover not just how to deploy a model on android but assumes a reader to have no understanding of deep learning, android development and asks for minimum coding experience.***

>Above said, this repo requires a reader to just know 
>* how to run a jupyter notebook 
>* deploy an android app on a device using android studio.
>* copy and paste files :p

**Yes, no coding required!** (All non-coders cheers!!). All the code is already in place so that you can focus on concepts you want to understand.

## Prerequisites
Prerequisities are 
>1.Python environment with following installed
>* Tensorflow 1.3 or greater
>* Jupyter notebook

**(avoid using the dependency version beyond 1.4.1 as they are compiled with jdk1.8 causing issues in android app)**

>2.Android Studio

***Check SETUP.md to complete your prerequisites***

## Tutorial 1 - Deploying a simple single node tensorflow model on Android
This notebook covers
>* Different type of nodes in tensorflow graph
>* Creating a single variable model in tensorflow
>* Exporting this model and deploying in an android application

## Tutorial 2 - Deploying a softmax tensorflow model for MNIST
This notebook covers
>* Creating a softmax model for MNIST digits problem
>* Export it using the freeze API provided by tensorflow
>* Running MNIST digit recognizer on android and deploying our trained softmax model

## Tutorial 3a - Deploying a convnet tensorflow model for MNIST
This notebook covers
>* Deploying a convolutional network to get superior results
>* Using exponentially decaying Learning Rate to learn faster
