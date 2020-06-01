pipeline {
    agent any
        environment {
            root = "/data/www/"
        }
        parameters {
               string(name: 'domain', defaultValue: 'iotpack.addpoints.cn', description: 'iotpack.addpoints.cn')
               string(name: 'version', defaultValue: 'daily', description: 'daily')
         }

    stages {
        stage("build web") {
                steps {
                    sh "cd web && npm install && cp .env.daily .env && npm run build && rm -rf /data/www/daily.iotpack.addpoints.cn"
                    sh "rm -rf /data/www/daily.iotpack.addpoints.cn && mkdir /data/www/daily.iotpack.addpoints.cn && mkdir /data/www/daily.iotpack.addpoints.cn/dist"
                    sh "cp -rf web/dist /data/www/daily.iotpack.addpoints.cn/dist"
                    sh "cp -rf daily.nginx.conf web/dist /data/www/daily.iotpack.addpoints.cn/"
                }
        }
        stage("build api") {
                steps {
                     sh "/root/.sdkman/candidates/maven/3.6.3/bin/mvn clean package -Dmaven.test.skip=true"
                     sh "mkdir /data/www/daily.iotpack.addpoints.cn/bin"
                     sh "cp  api/target/iotpack.jar /data/www/daily.iotpack.addpoints.cn/bin"
                }
        }
        stage("deploy") {
                steps {
                    sh "cp -rf supervisord.conf /data/www/daily.iotpack.addpoints.cn/"
                    sh "/usr/local/openresty/nginx/sbin/nginx -s reload"
                    sh "/usr/bin/supervisorctl -c /etc/supervisord.conf reload"
                }
            }
        }
}