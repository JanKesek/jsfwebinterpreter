create table challenge(id serial primary key unique, challenge_question text);
create table input_output(id serial primary key unique, input varchar(100), output varchar(100),challenge_id bigint, CONSTRAINT fk_challenge
  FOREIGN KEY(challenge_id) REFERENCES challenge(id)
);
