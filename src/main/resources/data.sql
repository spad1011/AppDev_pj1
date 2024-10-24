
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied) VALUES
                                                                                                  ('D02XY45', 3, 5, 1),
                                                                                                  ('A94B6F3', 4, 6, 0),
                                                                                                  ('T12AB34', 2, 4, 1),
                                                                                                  ('C15DE67', 5, 7, 1),
                                                                                                  ('F12GH89', 1, 2, 0),
                                                                                                  ('B78IJ01', 3, 5, 1),
                                                                                                  ('M34KL56', 4, 6, 0),
                                                                                                  ('P90QR78', 2, 4, 1),
                                                                                                  ('V23ST01', 5, 7, 1),
                                                                                                  ('X45UV67', 1, 2, 0),
                                                                                                  ('Y67WX89', 3, 5, 1),
                                                                                                  ('Z01YZ23', 4, 6, 0),
                                                                                                  ('Q45AB78', 2, 4, 1),
                                                                                                  ('R67CD01', 5, 7, 1);


INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Buddy', 'Dog', 'Golden Retriever', 3, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Mittens', 'Cat', 'Siamese', 2, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Charlie', 'Dog', 'Beagle', 4, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Whiskers', 'Cat', 'Persian', 5, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Coco', 'Rabbit', 'Holland Lop', 1, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Goldie', 'Fish', 'Goldfish', 1, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Polly', 'Bird', 'Parakeet', 2, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Max', 'Dog', 'German Shepherd', 5, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Luna', 'Cat', 'Maine Coon', 3, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_fk) VALUES ('Nibbles', 'Hamster', 'Syrian Hamster', 1, 'D02XY45')