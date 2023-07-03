-- 조건 검색
SELECT * 
FROM  factorys
inner join 
WHERE 1 = 1
-- company_id 끝자리 수
and COMPANY_ID > '%2'
-- company
and COMPANY like '%자동차'
;

-- 전체
SELECT * 
FROM  db_cars.factorys
WHERE 1 = 1
;

-- 상세
SELECT * 
FROM db_cars.factorys
where COMPANY_ID = 'C004'
;

-- 입력
insert into db_cars.factorys
(COMPANY_ID, COMPANY)
values
('C006', '재규어')
;

-- 수정
update factorys
set COMPANY = '링컨'
where COMPANY_ID = 'C006'
;

-- 삭제
delete from factorys
where COMPANY_ID = 'C006'
;