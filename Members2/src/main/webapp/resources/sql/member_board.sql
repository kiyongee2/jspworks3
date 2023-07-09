-- 회원 테이블
create table t_member(
	memberid	varchar(20),
    passwd		varchar(20) not null,
    name		varchar(30) not null,
    gender		varchar(10),
    joindate	timestamp default now(),
    primary key(memberId)
);

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

-- 댓글 테이블
create table t_reply(
	rno int primary key auto_increment,
    bnum int not null,
    rcontent text not null,
    replyer varchar(30) not null,
    rdate timestamp default now(),
    rupdate timestamp,
    constraint fk_reply_board foreign key(bnum)
    references t_board(bnum)
);
