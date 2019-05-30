drop table if exists species cascade;

CREATE TABLE "species" (
    "name" TEXT primary key,
    "family" TEXT,
    "description" TEXT
);
INSERT INTO "species" VALUES
    ('Bird','Vertebrate','Birds (Aves) are a group of endothermic vertebrates, characterised by feathers, toothless beaked jaws, the laying of hard-shelled eggs, a high metabolic rate, a four-chambered heart, and a lightweight but strong skeleton.'),
    ('Mammal','Vertebrate','Mammals (class Mammalia /məˈmeɪli.ə/ from Latin mamma "breast") are a clade of endothermic amniotes distinguished from reptiles and birds by the possession of a neocortex (a region of the brain), hair, three middle ear bones and mammary glands.'),
    ('Reptile','Vertebrate','Reptiles are a group (Reptilia) of tetrapod animals comprising today''s turtles, crocodilians, snakes, amphisbaenians, lizards, tuatara, and their extinct relatives.'),
    ('Amphibian','Vertebrate','The amphibians are tetrapods, a class of vertebrate animals with four limbs. They are non-amniotes, which means that their eggs are not surrounded by the several membranes, some impervious, which enable mammals, reptiles and birds to reproduce on land.');
