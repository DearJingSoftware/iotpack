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
                    sh "cd web && npm install && cp .env.daily .env && npm run build && rm -rf /data/www/daily.iotpack.addpoints.cn"
                    sh "rm -rf /data/www/daily.iotpack.addpoints.cn && mkdir /data/www/daily.iotpack.addpoints.cn && mkdir /data/www/daily.iotpack.addpoints.cn/dist"
                    sh "cp -rf web/dist /data/www/daily.iotpack.addpoints.cn/dist"
                    sh "cp -rf daily.nginx.conf web/dist /data/www/daily.iotpack.addpoints.cn/"
                }
        }
        stage("deploy") {
                steps {
                    sh "echo  'liunx 部署'"
                }
            }
        }
}