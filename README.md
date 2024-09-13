## 요구사항 분석 (e-커머스 서비스)

- 잔액 충전/조회 API
  - 결제에 사용될 금액을 충전하는 API 
  - 사용자 식별자 및 충전할 금액을 받아 잔액을 충전
  - 사용자 식별자를 통해 해당 사용자의 잔액을 조회

- 상품 조회 API
  - 상품 정보 ( ID, 이름, 가격, 잔여수량 ) 을 조회하는 API
  - 조회시점의 상품별 잔여수량이 정확하면 좋습니다.
    - 정확한 잔여수량 확인을 위해 Stock 테이블 구현

- 주문 / 결제 API
  - 사용자 식별자와 (상품 ID, 수량) 목록을 입력받아 주문하고 결제를 수행하는 API 
  - 결제는 기 충전된 잔액을 기반으로 수행하며 성공할 시 유저 잔액을 차감
  - 데이터 분석을 위해 결제 성공 시에 실시간으로 주문 정보를 데이터 플랫폼에 전송
    - Spring Event를 활용하여 주문 (성공) -> 재고 차감 -> 결제 (성공) -> 데이터 플랫폼에 정보 전송  

- 상위 상품 조회 API
  - 최근 3일간 가장 많이 팔린 상위 5개 상품 정보를 제공하는 API
  - 통계 정보를 다루기 위한 기술적 고민
    - 상위 상품 조회는 쿼리의 연산 비용이 높고 자주 요청되는 데이터라고 판단하여 DB Connection을 줄이기 위해 Redis Cache를 활용
    - 적절한 Cache Eviction 전략 필요

- 장바구니 기능
  - 사용자는 구매 이전에 관심 있는 상품들을 장바구니에 적재할 수 있다
  - 이 기능을 제공하기 위해 `장바구니에 상품 추가/삭제` API 와 `장바구니 조회` API 필요

#### Description

- 상품 주문에 필요한 메뉴 정보들을 구성하고 조회가
- 사용자는 상품을 여러개 선택해 주문할 수 있고, 미리 충전한 잔액을 이용
- 상품 주문 내역을 통해 판매량이 가장 높은 상품을 추천

#### Key Point

- 동시에 여러 주문이 들어올 경우, 유저의 보유 잔고에 대한 처리가 정확해야 한다.
- 각 상품의 재고 관리가 정상적으로 이루어져 잘못된 주문이 발생하지 않도록 해야 한다.

## ERD

![concert erd](https://raw.githubusercontent.com/corncode8/e-commerce/master/images/erd/erd.png)

## API 명세

#### 잔액 충전/조회 API

잔액 조회 API <br/>
| 메서드 | URL | 
|--------|-----------| 
| GET |/users/{id} | <br/>


잔액 충전 API <br/>
| 메서드 | URL | 
|--------|-----------| 
| PATCH |/users/charge | <br/>
<br/>

#### 상품 조회 API

상품 조회 API <br/>
| 메서드 | URL | 
|--------|-----------| 
| GET |/products/{id} | <br/>
<br/>

#### 상위 상품 조회 API

상위 상품 조회 API <br/>
| 메서드 | URL | 
|--------|-----------| 
| GET |/products/popular | <br/>
<br/>

#### 주문 / 결제 API

주문 / 결제 API <br/>
| 메서드 | URL | 
|--------|-----------| 
| POST |/orders/{userId} | <br/>
<br/>


