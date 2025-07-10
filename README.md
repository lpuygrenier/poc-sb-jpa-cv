```Bash
# from root
docker compose -f .\envdev\docker-compose.yml up -d --build
mvn clean install
mvn spring-boot:run
```
