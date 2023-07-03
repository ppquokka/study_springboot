-- 조건 검색
SELECT * 
FROM db_cars.car_infors
WHERE 1 = 1
-- 년도 이상
and YEAR > '2020'
-- car name
and CAR_NAME like '소%'
;

-- 전체
SELECT * 
FROM db_cars.car_infors
WHERE 1 = 1
;

-- 상세
SELECT * 
FROM db_cars.car_infors
where CAR_INFOR_ID = 'CI002'
;

-- 입력
insert into car_infors
(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)
values
('쏘렌토', '2020', 'CAR-02', 'C002')
;

-- 수정
update car_infors
set CAR_NAME = '코나'
where CAR_INFOR_ID = 'CAR-02'
;

-- 삭제
delete from car_infors
where CAR_INFOR_ID = 'CAR-02'
;