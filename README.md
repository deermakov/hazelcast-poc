# hazelcast-poc
PoC Spring Boot Hazelcast, включая:
- Hazelcast remote (client/server) mode is used. Embedded mode is not used.
- Hazelcast usage:
  - direct via HazelcastInstance
  - indirect via caching

## Инфраструктура
Конфигурация инфраструктуры: _/docker/docker-compose.yaml_ <br>
Запуск инфраструктуры: `docker-compose up -d` <br>
Остановка инфраструктуры: `docker-compose down -v` <br>

## Hazelcast Management Center
http://localhost:18080

## Swagger
http://localhost:8081/swagger-ui/index.html

Пример ИП:
```json
{
    "@class": "poc.hazelcast.domain.IndividualEntrepreneur",
    "id": "123",
    "name": "ИП Бахарев",
    "individual": {
        "@class": "poc.hazelcast.domain.Individual",
        "fio": "Бахарев Петр Петрович",
        "address": {
            "fullAddress": "Москва, 113327"
        }
    },
    "selfEmployed": true
}
```
## Замечания
1. JSON из запросов сохраняется в Hazelcast как есть, поэтому например Individual из состава IndividualEntrepreneur не сохраняется как отдельный Party