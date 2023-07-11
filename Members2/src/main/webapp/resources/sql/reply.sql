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
