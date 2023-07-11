-- 게시판 테이블
create table t_board(
	bnum	int primary key auto_increment,
    title	varchar(100) not null,
    content text,
    regdate timestamp default now(),
    modifydate timestamp,
    hit		int default 0,
    memberid varchar(20),
    fileupload varchar(50),
    constraint fk_member_board foreign key (memberid)
    references t_member(memberid) on delete cascade
);