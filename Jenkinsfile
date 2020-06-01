pipeline {
    agent any
    stages {
        stage("build") {
                steps {
                    sh "echo  '构建'"
                }
        }
        stage("build web") {
                steps {
                    sh "cd web && npm install && cp .env.daily .env && npm run build && rm -rf /var/www/api.daily.iotpack.addpoints.cn"
                    sh "rm -rf /var/www/api.daily.iotpack.addpoints.cn && mkdir /var/www/api.daily.iotpack.addpoints.cn && && mkdir /var/www/api.daily.iotpack.addpoints.cn/dist"
                    sh "cp -rf web/dist /var/www/api.daily.iotpack.addpoints.cn/dist"
                    sh "cp -rf daily.nginx.conf web/dist /var/www/api.daily.iotpack.addpoints.cn/"
                }
        }
        stage("deploy") {
                steps {
                    sh "echo  'liunx 部署'"
                }
            }
        }
}