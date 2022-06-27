CHERRY MARKET
=============
*<http://stone82.net:8088>

### 실행방법
1. docker 설치
2. 
```
./cherry/gradlew --refresh-dependencies
./cherry/gradlew clean build
docker-compose up -d
```

#### 주의사항
서버 이미지와 DB 저장을 로컬 폴더에 마운트 시켜놓았기 때문에 docker-compose.yaml 파일의 volumes부분을 내가 저장하고 싶은 로컬 폴더 위치로 수정해주어야 한다
```
//ex
volumes:
      - /mnt/hdd_0/db/oracle/cherry_market:/u01/app/oracle  - (나의 로컬폴더 위치):(도커컨테이너 내에 저장 위치)
```

#### 개발repository
* <https://github.com/kikizizi/cherry>


