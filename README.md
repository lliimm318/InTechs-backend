# InTech

프로젝트 관리 협업 어플리케이션



## 목차

1. [프로젝트 소개](#프로젝트-소개)
2. [기획 배경](#기획-배경)
3. [파일 구조](파일-구조)
4. [개발팀 소개](개발팀-소개)



## 프로젝트 소개

**InTechs**

최소한의 기능을 담아 사용자의 러닝 커브를 낮춘 프로젝트 협업 애플리케이션



**Skills**

Language - Java

Framework - Spring boot

Library - Spring data JPA, Web Socket

DataBase - MongoDB, Redis

infra - AWS(EC2, S3)



## 기획 배경

 대덕 소프트웨어 마이스터고등학교의 학생들은 소통을 위해 페이스북 메신저를, 프로젝트 관리를 위해 노션을 주로 사용합니다.  메신저는 사적인 소통을 위해  많이 사용합니다. 그래서 사적인 공간과 공적인 공간을 구분하기 어렵습니다. 노션은 ToDoList를 활용해 팀원마다 해야 할 일을 나누고, 진행도를 보고하는 용도로 사용했다. 하지만 업무용 메신저의 애플리케이션과 ToDoList 등의 일정관리의 기능을 지원하는 어플리케이션이 달랐기에 프로젝트 관리라는 목표를 위해서 두 애플리케이션을 함께 사용해야했습니다. 이는 불필요한 회원가입 및 로그인, 어플리케이션을 옮겨다니는 시간 및 자원 낭비를 유발하였습니다.

 기존의 협업 애플리케이션은 러닝 커브가 높은 편입니다. 학생들에게 협업 애플리캐이션을 사용하지 않는 이유를 물어본 결과 기능이 많아서 어렵다는 답이 다수를 차지 했습니다. 기존의 협업 애플리캐이션은 지나치게 많은 기능들을 지원해줘서 사용자가 애플리케이션을 익히는데 많은 시간과 노력이 들어갔습니다. 

 InTechs는 업무용 메신저와 일정관리를 위한 애플리케이션 입니다. 첫째, 개발자들은 프로젝트 관리를 위한 애플리케이션이 필요하였습니다. 둘째, 메신저와 일정관리의 기능을 동시에 가지고 있는 애플리케이션이 필요하였다. 셋째, 일정관리를 위한 애플리케이션은 지나치게 ToDoList와 같은 간단한 기능만을 지원하거나, 문서 작성, 프로젝트 팀원들의 관리 등의 너무나 많은 기능을 지원해 모든 기능을 효율적으로 사용할 수 없었습니다. InTechs는 이러한 문제점들을 해결하기 위해 기획하게 되었습니다.



## 파일 구조

```
src
 ㄴ main
 		ㄴ java
 				ㄴ InTechs.InTechs
 						ㄴ domain
 							ㄴ controller
 							ㄴ entity
 								ㄴ entity
 								ㄴ repository
 							ㄴ payload
 									ㄴ request
 									ㄴ response
 							ㄴ service
 						ㄴ config
 						ㄴ file
                        ㄴ exception
                        		ㄴ exceptions
                        ㄴ security
                ㄴ resources      
```





## 개발팀 소개

| Github                                     | 이름   | 역할    | 설명                                        |
| ------------------------------------------ | ------ | ------- | ------------------------------------------- |
| [joungeun](https://github.com/joungeun)    | 이종은 | BackEnd | InTech 백엔드를 담당하였습니다.             |
| [Goeun1001](https://github.com/Goeun)      | 임서영 | BackEnd | InTech 백엔드를 담당하였습니다.             |
| [lliimm0318](https://github.com/lliimm318) | 정고은 | Client  | InTech iOS, macOS, watchOS를 담당하였습니다 |

