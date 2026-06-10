-- data.sql (더미데이터 삽입)

-- user 더미 데이터
INSERT INTO users (nickname , email) VALUES 
('ironman','ironman@avengers.com'),
('spiderman','spiderman@avengers.com'),
('hulk','hulk@avengers.com'),
('captainamerica','captain@avengers.com'),
('thor','thor@avengers.com');

-- posts 더미 데이터
INSERT INTO posts (user_id , title, content) VALUES 
(1,'EDITH 주인 모집','스파이더맨이 너무 어려 EDITH 사용자 모집중'),
(4,'시빌워 참가자 모집','아이언맨이랑 싸우게 됐는데 상대팀 참가자 모집함'),
(5,'묠니르 부서짐','스톰브레이커 제작 중');