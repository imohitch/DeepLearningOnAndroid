
# DeepLearningOnAndroid 

My First attempt at writing an article, really excited :smiley:. Check out the article accompanying this repository.
 * [article link not working yet](http://www.google.com)

This repository contains the material for deploying deep learning models on mobile and embedded platforms like Raspberry pi. I plan to make this a one stop tutorial series to deploy any kind of Neural Network developed on any framework like Tensorflow, Pytorch, CNTK etc.

Tutorials are created as jupyter notebooks so that instead of just reading or just seeing code at a time, you can better understand what you read while executing actual code. 

## Audience 
>This repo is for anyone who 
>* has interest in deep learning but no idea about it
>* wants to understand basics of deep learning and tensorflow
>* has some or no coding experience


***This series of tutorials cover not just how to deploy a model on android but assumes a reader to have no understanding of deep learning, android development and minimum coding experience.***

>Above said, this repo requires a reader to just know 
>* how to run a jupyter notebook 
>* deploy an android app on a device using android studio.
>* copy and paste files :p

**Yes, no coding required!** (All non-coders cheers!!). All the code is already in place so that you can focus on concepts you want to understand.



## Overview
(This section is boring, you can skip :D )

This repository provides to the point tutorials for deploying any type of deep learning models created on any deep learning framework on mobile platform ( Tensorflow models on Android devices as of now ). **Most of the articles currently available online mostly give steps followed by the authors to deploy, without providing sufficient explaination why it is being done and what is happening behind the scenes. This creates problem when we have to deploy a new model with different Inputs and Outputs.**

To ensure readers have a thorough understanding of what they are doing I will be covering fundamentals of Tensorflow architecture and its fundamentals a deep learner (:p) should know.



## Prerequisites
Prerequisities are 
>1.Python environment with following installed
>* Tensorflow 1.3 or greater
>* Jupyter notebook

>2.Android Studio

***Check SETUP.md to complete your prerequisites***



## Tutorial 0 - Overview of Deep Learning and Tensorflow
This notebook covers
>* Background for deep learning
>* What are neural networks, nodes, dataset etc
>* What is tensorflow 
>* Concept of graph and session in tensorflow

## Tutorial 1 - Deploying a simple tensorflow model on Android
This notebook covers
>* Different type of nodes in tensorflow graph
>* Creating a single variable model in tensorflow
>* Exporting this model and deploying in an android application

## Tutorial 2 - Deploying a softmax tensorflow model for MNIST
This notebook covers
>* Creating a softmax model for MNIST digits problem
>* Exporting it using the freeze API provided by tensorflow
>* Running MNIST digits recognizer on android and deploying out trained softmax model

## Tutorial 3a - Deploying a convnet tensorflow model for MNIST
This notebook covers
>* Deploying a convolutional network to get superior results
