
pipeline {
    agent any

    stages {
        
        stage('Docker Check') {
            steps {
                bat '''
                    echo Checking Docker
                    where docker
                    docker --version
                    docker ps
                '''
            }
        }
        stage('Git Checkout') {
            steps {
                echo 'Getting latest source code'
                checkout scm
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t admission-website:%BUILD_NUMBER% .'
            }
        }

        stage('Stop Old Container') {
            steps {
                script {
                    bat(returnStatus: true,
                        script: 'docker rm -f admission-website')
                }
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker run -d --name admission-website -p 8081:80 admission-website:%BUILD_NUMBER%'
            }
        }

    }
}
