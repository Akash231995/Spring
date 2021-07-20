pipeline {
  agent any
  tools {
    maven 'Maven'
  }
  stages {
    stage ('Initialize') {
      steps {
        bat '''
                echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
           '''
      }
    }
    stage ('Build') {
      steps {
        bat 'mvn clean package'
      }
    }
    stage('Deploy') { 
            steps {
                bat 'echo F | xcopy C:/WINDOWS/system32/configsystemprofile/AppData/Local/Jenkins/.jenkins/workspace/demo-project/target/SpringMVC.war F:/Software/jboss-eap/standalone/deployments/SpringMVC.war'
            }
        }
  }
}
