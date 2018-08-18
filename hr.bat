call mvn -B -s settings.xml -DskipTests=true clean install
call java -Dspring.profiles.active="heroku" -DJAWSDB_URL="mysql://springstudent:springstudent@localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC"  -jar mvc/web-customer-tracker/target/dependency/webapp-runner.jar mvc/web-customer-tracker/target/*.war

