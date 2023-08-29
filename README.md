# hazelcast-poc
PoC Spring Boot Hazelcast, включая:
- Hazelcast remote (client/server) mode is used
  - Embedded mode is not used
  - Hazelcast cluster is in Docker
- Hazelcast usage:
  - direct via HazelcastInstance
  - indirect via caching
- Map backup count ("replication ratio")

## Инфраструктура
- Конфигурация инфраструктуры: _/docker/docker-compose.yaml_ <br>
- Запуск инфраструктуры: `docker-compose up -d` <br>
- Остановка инфраструктуры: `docker-compose down -v` <br>

ВАЖНО: в docker-compose.yaml в HZ_NETWORK_PUBLICADDRESS надо поставить IP адрес хоста (см. ниже)

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
1. JSON из запросов сохраняется в Hazelcast как есть, поэтому
например Individual из состава IndividualEntrepreneur не
сохраняется как отдельный Party.
2. Важно задавать свойство HZ_NETWORK_PUBLICADDRESS у узлов
кластера Hazelcast.
   - это должен быть внешний IP:port адрес docker-контейнера,
в котором крутится этот узел, напр. в PoC это IP локальной
машины. Важно: адреса localhost или 127.0.0.1 не подойдут, т.к. узел
работает внутри контейнера и в качестве этих адресов возьмет
localhost или 127.0.0.1 контейнера, а не хоста, и в итоге узлы
не увидят друг друга и кластер не соберется.
   - этот адрес виден Java-клиенту (см. "Members" в логах), и
по нему клиент будет ходить к узлам.
3. Для простоты настроек кластер Hazelcast сделан статическим
(3 узла с фиксированными портами), а не через docker scale