pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/main']],userRemoteConfigs:
                [[credentialsId: 'github-ssh-key', url: 'git@github.com:tiffanyanneso/test.git']]]
            }
        }

        stage('Build'){
            steps{
                sh 'mkdir lib'
                sh 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                sh 'javac -cp "lib/junit-platform-console-standalone-1.7.0-all.jar" Calculator.java CalculatorTest.java main.java'
            }
        }

        stage('Test'){
            steps{
                sh 'java -jar lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class CalculatorTest --reports-dir="reports"'
                junit 'reports/*-jupiter.xml'
            }
        }

        stage('Deploy'){
            steps{
                sh 'java main' 
            }
        }
    }

}
