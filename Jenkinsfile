pipeline {
    agent any
    stages {
        stage("build") {
                steps {
                    sh "echo  '构建'"
                }
        }
        stage("liunx_deploy") {
                steps {
                    sh "echo  'liunx 部署'"
                }
            }
        }
        stage("windows_deploy") {
                        steps {
                            sh "echo  'liunx 部署'"
                        }
                    }
                }
        stage("docker_deploy") {
                steps {
                    sh "echo  'docker 部署'"
                }
            }
        }

        stage("k8s_deploy") {
                steps {
                    sh "echo  '测试'"
                }
            }
        }
}
