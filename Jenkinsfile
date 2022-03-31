def deploy_module = {
    sh "mvn -Drepo.id=snapshots -Drepo.login=$REPO_USER -Drepo.pwd=$REPO_USER_PWD -Premote-artefact -pl ${env.MODULE} clean deploy -U"
}

pipeline {
    agent any
    tools {
        maven "3.6.3"
        jdk "jdk11"
    }
    environment {
       REPO_USER = credentials('repo_user')
       REPO_USER_PWD = credentials('repo_user_password')
    }
    stages {
       stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
                sh 'whoami'
                sh 'id -u'
                sh 'docker --version'
                sh 'docker ps'
            }
        }
        stage('Testing unstable') {
            when {
                anyOf {
                    changeset "greeting-components/**"
                    changeset "greeting-app/**"
                }
                not {
                   anyOf {
                     branch 'main'
                     branch 'dev'
                   }
                }
            }
            steps {
                sh "mvn clean test"
            }
        }
        stage('Build greeting-components - dev') {
            environment {
                MODULE = "greeting-components"
            }
            when {
                expression { env.BRANCH_NAME == 'dev' }
            }
            steps {
                echo "Building greeting-components dev"
                script { deploy_module() }
            }
        }
        stage('Build greeting-app - dev') {
            environment {
                MODULE = "greeting-app"
            }
            when {
                expression { env.BRANCH_NAME == 'dev' }
            }
            steps {
                echo "Building greeting-app dev"
                script { deploy_module() }
            }
        }
        stage('Build all') {
            when {
                expression { env.BRANCH_NAME == 'main' }
            }
            steps {
                sh "mvn -Drepo.id=snapshots -Drepo.login=$REPO_USER -Drepo.pwd=$REPO_USER_PWD clean deploy"
            }
        }
     }
}
