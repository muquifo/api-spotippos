pipeline {
  agent {
    docker {
      image 'java:8'
      args '-p 3000:3000'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn install'
      }
    }
  }
}