pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: 'main']],userRemoteConfigs:
                [[credentialsId: 'github-ssh-key', url: 'git@github.com:tiffanyanneso/test.git']]]
            }
        }

        stage('Build'){
            steps{
                bat 'cd src'
                bat 'javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" CalculatorTest.java Calculator.java main.java'
            }
        }

        stage('Test'){
            steps{
                bat 'cd src'
                bat 'java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class CalculatorTest --reports-dir="reports"'
                junit 'src/reports/*-jupiter.xml'
            }
        }

        stage('Deploy'){
            steps{
                bat 'cd src'
                bat 'java main' 
            }
        }
    }

}
