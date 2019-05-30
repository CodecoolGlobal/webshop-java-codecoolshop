drop table if exists animals;

CREATE TABLE "animals" (
    "id" SERIAL NOT NULL UNIQUE PRIMARY KEY,
    "name" TEXT,
    "species" TEXT constraint animals_species references species,
    "price" INT,
    "currency" TEXT,
    "description" TEXT,
    "img_url" TEXT
);

INSERT INTO "animals" VALUES
    (DEFAULT,'Griffon Vulture','Bird',1990,'USD','The griffon vulture is 93-122 cm (37-48 in) long with a 2.3-2.8 m (7.5-9.2 ft) wingspan. In the nominate race the males weigh 6.2 to 10.5 kg (14 to 23 lb) and females typically weigh 6.5 to 11.3 kg (14 to 25 lb), while in the Indian subspecies (G. f. fulvescens), the vultures average 7.1 kg (16 lb). Extreme adult weights have been reported from 4.5 to 15 kg (9.9 to 33.1 lb), the latter likely a weight attained in captivity. Hatched naked, it is a typical Old World vulture in appearance, with a very white head, very broad wings and short tail feathers. It has a white neck ruff and yellow bill. The buff body and wing coverts contrast with the dark flight feathers.','https://vignette.wikia.nocookie.net/animals/images/c/c9/Depositphotos_34843177-Eurasian-griffon.-vulture.jpg/revision/latest?cb=20160421023933'),
    (DEFAULT,'Bald Eagle','Bird',3490,'USD','The Bald eagle (Haliaeetus leucocephalus, from Greek hali "sea", aietos "eagle", leuco "white", cephalos "head") is a bird of prey found in North America. A sea eagle, it has two known subspecies and forms a species pair with the white-tailed eagle (Haliaeetus albicilla). Its range includes most of Canada and Alaska, all of the contiguous United States, and northern Mexico. It is found near large bodies of open water with an abundant food supply and old-growth trees for nesting. The bald eagle is an opportunistic feeder which subsists mainly on fish, which it swoops down and snatches from the water with its talons.','https://vignette.wikia.nocookie.net/animals/images/8/80/Bald_Eagle.jpg/revision/latest?cb=20181221184710'),
    (DEFAULT,'Osprey','Bird',1249,'USD','The osprey (Pandion haliaetus) - also called fish eagle, sea hawk, river hawk, and fish hawk - is a diurnal, fish-eating bird of prey with a cosmopolitan range. It is a large raptor, reaching more than 60 cm (24 in) in length and 180 cm (71 in) across the wings. It is brown on the upperparts and predominantly greyish on the head and underparts. The osprey tolerates a wide variety of habitats, nesting in any location near a body of water providing an adequate food supply. It is found on all continents except Antarctica, although in South America it occurs only as a non-breeding migrant.','https://vignette.wikia.nocookie.net/animals/images/7/75/Osprey.jpg/revision/latest?cb=20120527074703'),
    (DEFAULT,'Southern Cassowary','Bird',8990,'USD','The Southern Cassowary is a specie from the Casuarius genus. It lives in Northern Australia. It is a large, flightless bird. It is mainly black physique, a blue head and neck, a large casque on its head, two large red wattles, and sharp claws on its foot. They have a length of 4-5.5 ft. They have a height of up to 5 ft. They can weigh up to 63-128 lb.','https://vignette.wikia.nocookie.net/animals/images/2/28/Southern_Cassowary.jpg/revision/latest?cb=20120525034613'),
    (DEFAULT,'Wilson''s Bird-of-paradise','Bird',5499,'USD','The Wilson''s bird-of-paradise (Cicinnurus respublica), is a species of bird-of-paradise. An Indonesian endemic, the Wilson''s bird-of-paradise is distributed to the hill and lowland rainforests of Waigeo and Batanta Islands off West Papua. Its diet consists mainly of fruits and small insects. Due to ongoing habitat loss, limited range and exploitation, the Wilson''s bird-of-paradise is evaluated as Near Threatened on the IUCN Red List of Threatened Species. It is listed on Appendix II of the Convention on International Trade in Endangered Species of Wild Fauna and Flora (CITES).','https://vignette.wikia.nocookie.net/animals/images/7/70/Wilsons_Bird-of-paradise_Cicinnurus_respublica2_0.jpg/revision/latest?cb=20160307003933'),
    (DEFAULT,'Henderson Fruit Dove','Bird',12990,'USD','The Henderson fruit dove (Ptilinopus insularis), also known as scarlet-capped fruit dove, is a species of dove in the Columbidae family. It is endemic to Henderson Island in the Pitcairn Island group. Its natural habitat is tropical moist lowland scrub forest.','https://vignette.wikia.nocookie.net/animals/images/1/18/P_hendersoni.jpg/revision/latest?cb=20160808032012'),
    (DEFAULT,'Seram Swiftlet','Bird',799,'USD','The Seram swiftlet (Aerodramus ceramensis), is a species of swift in the Apodidae family. It is endemic to Buru and Seram Islands. It used to be considered a subspecies of the Moluccan swiftlet. Its natural habitats are subtropical or tropical moist lowland forests and subtropical or tropical moist montane forests.','https://vignette.wikia.nocookie.net/animals/images/d/d3/Moluccanswift2.jpg/revision/latest?cb=20160826191222'),
    (DEFAULT,'Yap Monarch','Bird',499,'USD','The Yap monarch (Monarcha godeffroyi), is a species of monarch flycatcher in the Monarchidae family. It is endemic to Micronesia. Its natural habitats are subtropical or tropical moist lowland forests and subtropical or tropical mangrove forests.','https://vignette.wikia.nocookie.net/animals/images/5/5a/20100206002034.jpg/revision/latest?cb=20151125225519'),
    (DEFAULT,'Harpy Eagle','Bird',999,'USD','It is sometimes known as the American harpy eagle to distinguish it from the Papuan eagle, which is sometimes known as the New Guinea harpy eagle or Papuan harpy eagle. It is the largest and most powerful raptor found in the Americas, and among the largest extant species of eagles in the world. It usually inhabits tropical lowland rainforests in the upper (emergent) canopy layer. Destruction of its natural habitat has caused it to vanish from many parts of its former range, and it is nearly extirpated in Central America. In Brazil, the harpy eagle is also known as royal-hawk.','https://vignette.wikia.nocookie.net/animals/images/f/fe/8e495ffbe5c95cfdc38c5501751ff25d.jpg/revision/latest?cb=20160411193709'),
    (DEFAULT,'Speckled Piculet','Bird',1390,'USD','The male and female birds look alike. They have olive-green backs, with two white stripes on the side of their heads. The male bird has orange and brown on the forecrown. They have a creamy-white coloring below, with black spots. There is a dark green band near the eyes.','https://vignette.wikia.nocookie.net/animals/images/8/8d/Speckled_piculet_copy1.jpg/revision/latest/?cb=20170109010813'),
    (DEFAULT,'Congo Serpent Eagle','Bird',2990,'USD','The Congo serpent eagle (Dryotriorchis spectabilis), is a species of bird of prey in the Accipitridae family. It is placed in the monotypic genus Dryotriorchis. This species is found in western and central Africa, with its range stretching from Sierra Leone south to Angola and west to the Democratic Republic of the Congo. It occurs in upper and lower Guinean forests, which are dense rainforests. This serpent eagle specializes in hunting in these forests'' dark understories.','https://vignette.wikia.nocookie.net/animals/images/2/21/Dryotriorchis_spectabilis.jpg/revision/latest?cb=20160405022745'),
    (DEFAULT,'Bearded Bellbird','Bird',6990,'USD','This cotinga occurs in humid forests and woodland. It is mainly resident, but some populations take part in altitudinal migrations; breeding at altitudes of up to 1900 m (6250 ft) and spending the non-breeding season in the lowlands. It is a localised and uncommon bird in Venezuela, but is fairly common in Trinidad. The nominate Brazilian race is relatively rare due to extensive habitat destruction in its range and heavy trapping for the cagebird trade, and as such is considered "vulnerable" by Brazilian environmental authority (IBAMA).','https://vignette.wikia.nocookie.net/animals/images/6/61/BeardedBellbird_100301_6211.jpg/revision/latest?cb=20141225234300'),
    (DEFAULT,'Western Gorilla','Mammal',7290,'USD','The Western gorilla (Gorilla gorilla) is a great ape and the most populous species of the genus Gorilla. Nearly all of the individuals of this taxon belong to the western lowland gorilla subspecies (G. g. gorilla) whose population is approximately 95,000 individuals. Only 250 to 300 of the only other western gorilla subspecies, the cross river gorilla (G. g. diehli) are thought to remain.','https://vignette.wikia.nocookie.net/animals/images/1/15/Gorilla.jpg/revision/latest?cb=20120527170304'),
    (DEFAULT,'Snow Leopard','Mammal',15490,'USD','The Snow Leopard is a species from the Panthera genus. It is found in the snowy woodlands of Central Asia. Snow leopards have long thick fur, and their base colour varies from smoky gray to yellowish tan, with whitish underparts. They have dark gray to black open rosettes on their body with small spots of the same color on their heads and larger spots on their legs and tail. Unusually among cats, their eyes are pale green or gray in color.','https://vignette.wikia.nocookie.net/animals/images/1/19/Snow_Leopard.jpg/revision/latest?cb=20181221200225'),
    (DEFAULT,'Humpback Whale','Mammal',39990,'USD','The Humpback Whale is a species from the Megaptera genus. Found in oceans and seas around the world, humpback whales typically migrate up to 25,000 kilometres (16,000 mi) each year. A Humpback whale can easily be identified by its stocky body with an obvious hump and black dorsal coloring. The head and lower jaw are covered with knobs called tubercles, which are actually hair follicles, and are characteristic of the species. The fluked tail, which it lifts above the surface in some dive sequences, has wavy trailing edges. The long black and white tail fin, which can be up to a third of body length, and the pectoral fins have unique patterns, which make individual whales identifiable.','https://vignette.wikia.nocookie.net/animals/images/4/41/Humpback_Whale.jpg/revision/latest?cb=20181221184349'),
    (DEFAULT,'Gray Wolf','Mammal',14990,'USD','The Gray Wolf is a species of the Canis genus. It is native to Eurasia, North Africa and North America. It has a slender body with a powerful build. It has triangular ears and wide forehead, and has strong jaws. The front paws have five toes each while the back paws have four. Gray Wolves travel and hunts in packs. They''re also highly territorial.','https://vignette.wikia.nocookie.net/animals/images/b/bc/Gray_Wolf.jpg/revision/latest?cb=20120824083608'),
    (DEFAULT,'Moose','Mammal',27990,'USD','The moose (North America) or elk (Eurasia), Alces alces, is the largest extant species in the deer family. Moose are distinguished by the palmate antlers of the males; other members of the family have antlers with a dendritic ("twig-like") configuration. Moose typically inhabit boreal and mixed deciduous forests of the Northern Hemisphere in temperate to subarctic climates. Moose used to have a much wider range but hunting and other human activities have greatly reduced it. Moose have been reintroduced to some of their former habitats. Currently, most moose are found in Canada, Alaska, New England, Scandinavia, Latvia, Estonia and Russia. Their diet consists of both terrestrial and aquatic vegetation. The most common moose predators are wolves, bears and humans.','https://vignette.wikia.nocookie.net/animals/images/a/a3/Moose.jpg/revision/latest?cb=20181221184550'),
    (DEFAULT,'Brown Bear','Mammal',99990,'USD','The Brown Bear is a species of a bear that is found in North America. It is also known as the Grizzly bear. The awe-inspiring brown bear lives in the forests and mountains of northern North America, Europe, and Asia. It is the most widely distributed bear in the world. Brown bears have very large and curved claws, those present on the forelimbs being longer than those on the hind limbs. They may reach 5 to 6 centimeters (2.0 to 2.4 in) and sometimes 7 to 10 centimeters (2.8 to 3.9 in) along the curve. They are generally dark with a light tip, with some forms having completely light claws. Brown bear claws are longer and straighter than those of American black bears. The claws are blunt, while those of a black bear are sharp. It can make you it''s pet.','https://vignette.wikia.nocookie.net/animals/images/9/95/Kodiak_Bear.jpg/revision/latest?cb=20120515121821'),
    (DEFAULT,'Tiger','Mammal',49990,'USD','The Tiger is a species from the of Panthera genus. Native to much of eastern and southern Asia. The tiger is an apex predator and an obligate carnivore. Reaching up to 3.3 metres (11 ft) in total length and weighing up to 300 kilograms (660 pounds), the larger tiger subspecies are comparable in size to the biggest extinct felids. Aside from their great bulk and power, their most recognizable feature is the pattern of dark vertical stripes that overlays near-white to reddish-orange fur, with lighter underparts. The most numerous tiger subspecies is the Bengal tiger while the largest subspecies is the Siberian tiger.','https://vignette.wikia.nocookie.net/animals/images/0/05/Tiger.jpg/revision/latest?cb=20181221165111'),
    (DEFAULT,'Lion','Mammal',32790,'USD','The lion (Panthera leo) is one of the big cats in the genus Panthera and a member of the family Felidae. The commonly used term African lion collectively denotes the several subspecies found in Africa. With some males exceeding 250 kg (550 lb) in weight, it is the second-largest living cat after the tiger. Wild lions currently exist in sub-Saharan Africa and in India (where an endangered remnant population resides in Gir Forest National Park). In ancient historic times, their range was in most of Africa, including North Africa, and across Eurasia from Greece and southeastern Europe to India.','https://vignette.wikia.nocookie.net/animals/images/d/d2/Lion.jpg/revision/latest?cb=20181222014314'),
    (DEFAULT,'Leopard','Mammal',26790,'USD','The leopard (Panthera pardus) is one of the five "big cats" in the genus Panthera. It is a member of the familyFelidae with a wide range in sub-Saharan Africa and parts of Asia. Fossil records found in Italy suggest that in the Pleistocene it ranged as far as Europe and Japan. Compared to other members of Felidae, the leopard has relatively short legs and a long body with a large skull. It is similar in appearance to the jaguar, but is smaller and more lightly built. Its fur is marked with rosettessimilar to those of the jaguar, but the leopard''s rosettes are smaller and more densely packed, and do not usually have central spots as the jaguar''s do. Both leopards and jaguars that are melanistic are known as black panthers.','https://vignette.wikia.nocookie.net/animals/images/a/ae/Leopard.jpg/revision/latest?cb=20181221204105'),
    (DEFAULT,'Aardvark','Mammal',799,'USD','The Aardvark, (Orycteropus afer), is a medium-sized, burrowing, nocturnal mammal native to Africa. t is the only living species of the order Tubulidentata, although other prehistoric species and genera of Tubulidentata are known. The aardvark looks like a cross between a pig and an anteater. Its body is stout with an arched back and is sparsely covered with coarse hairs. The limbs are of moderate length. The front feet have lost the pollex (or ''thumb''), resulting in four toes, while the rear feet have all five toes.','https://vignette.wikia.nocookie.net/animals/images/5/5f/Aardvark.jpg/revision/latest?cb=20120606060128'),
    (DEFAULT,'Bison','Mammal',37490,'USD','The Bison is a genus from the Bovidae family. There are two extant and four extinct species recognized. Of the four extinct species, three were North American; Bison antiquus, B. latifrons, and B. occidentalis. The fourth; the Bison priscus ranged across steppe environments from Western Europe, through Central Asia, and onto North America. There are two surviving species; the American bison, Bison bison, also known as the American buffalo, found only in North America, is the most numerous. (It is only distantly related to the true buffalo.)','https://vignette.wikia.nocookie.net/animals/images/3/3e/American_Bison.jpg/revision/latest?cb=20120601045550'),
    (DEFAULT,'Cheetah','Mammal',24990,'USD','The cheetah (Acinonyx jubatus), also known as the hunting leopard, is a big cat that occurs mainly in eastern and southern Africa and a few parts of Iran. The only extant member of the genus Acinonyx, the cheetah was first described by Johann Christian Daniel von Schreber in 1775. The cheetah is characterised by a slender body, deep chest, spotted coat, a small rounded head, black tear-like streaks on the face, long thin legs and a long spotted tail. Its lightly built, thin form is in sharp contrast with the robust build of the other big cats.','https://vignette.wikia.nocookie.net/animals/images/8/8e/Cheetah.jpg/revision/latest?cb=20181221181800'),
    (DEFAULT,'Inland Taipan','Reptile',1290,'USD','The Inland Taipan is a specie from the Oxyranus that in native to Australia. The Inland Tapian has a dark tan, ranging from a rich, dark hue to a brownish olive-green, depending on season. Its back, sides and tail may be different shades of brown and grey, with many scales having a wide blackish edge. The lowermost lateral scales often have an anterior yellow edge. The eye is of average size with a blackish brown iris and without a noticeable coloured rim around the pupil.','https://vignette.wikia.nocookie.net/animals/images/5/5e/Inland_Taipan.jpg/revision/latest?cb=20120526014446'),
    (DEFAULT,'Green Sea Turtle','Reptile',499,'USD','The Green Sea Turtle is a specie from the Cholonia genus. Its range extends throughout tropical and subtropical seas and oceans around the world, with two distinct populations in the Atlantic and Pacific Oceans. It has a teardrop-shaped carapace with a flattened body. It has a pair of paddle-like flippers and a beaked head at the end of its short neck.','https://vignette.wikia.nocookie.net/animals/images/3/33/Green_Sea_Turtle.jpg/revision/latest?cb=20181221182939'),
    (DEFAULT,'Komodo Dragon','Reptile',7690,'USD','The Komodo dragon, (Varanus komodoensis), also known as the komodo monitor, is a large species of lizard found in the Indonesian islands of Komodo, Rinca, Flores, Gili Motang, and Padar. A member of the monitor lizard family it is the largest living species of lizard, growing to a maximum length of 3 metres (10 ft) in rare cases and weighing up to approximately 70 kilograms (150 lb). Their unusually large size has been attributed to island gigantism, since no other carnivorous animals fill the niche on the islands where they live.','https://vignette.wikia.nocookie.net/animals/images/3/3e/Komodo-dragon_599_600x450.jpg/revision/latest?cb=20130804224809'),
    (DEFAULT,'Egyptian Cobra','Reptile',2390,'USD','The Egyptian cobra (Naja haje) is a species in the genus Naja, found in Africa and the Arabian Peninsula. It is one of the largest Naja species in Africa. The Egyptian cobra was first described by Swedish zoologist Carolus Linnaeus in 1758. The generic name naja is a Latinisation of the Sanskrit word naga meaning "cobra". The specific epithet haje is derived from the Arabic word hayya which literally means small "snake"-according to the Quran or "viper".','https://vignette.wikia.nocookie.net/animals/images/2/20/Egyptian-Cobra.jpg/revision/latest?cb=20130807221716'),
    (DEFAULT,'Round Island Burrowing Boa','Reptile',1790,'USD','The Round island burrowing boa (Bolyeria multocarinata), is a extinct species of snake in the Bolyeriidae family, in the monotypic genus Bolyeria, which was endemic to Mauritius/Mauritius. The species was last seen on Round Island in 1975. No subspecies are currently recognized. It reached about 1 m (3 ft 3 in) in length, but preserved specimens have reported total lengths of 54-140 cm. Its colour was described as light brown with blackish spots dorsally and pink marbled with blackish ventrally. It had a pointed snout with a cylindrical body and head. Its general body form suggests that the Round Island Burrowing Boa had fossorial tendencies.','https://vignette.wikia.nocookie.net/animals/images/3/31/Bolyeria-multocarinata.jpg/revision/latest?cb=20140807031644'),
    (DEFAULT,'Nile Crocodile','Reptile',14990,'USD','The Nile crocodile (Crocodylus niloticus) is an African crocodile and may be considered the second largest extant reptile in the world, after the saltwater crocodile (Crocodylus porosus). The Nile crocodile is quite widespread throughout Sub-Saharan Africa, occurring mostly in the central, eastern, and southern regions of the continent and lives in different types of aquatic environments such as lakes, rivers and marshlands. Although capable of living in saline environments, this species is rarely found in saltwater, but occasionally inhabits deltas and brackish lakes. The range of this species once stretched northward throughout the Nile, as far north as the Nile delta.','https://vignette.wikia.nocookie.net/animals/images/a/a9/Nile_Crocodile.jpg/revision/latest?cb=20181231201310'),
    (DEFAULT,'American Alligator','Reptile',17890,'USD','The American Alligator is a large reptile that lives in the Southeast parts of the United States. The American alligator has a large, slightly rounded body, with thick limbs, a broad head, and a very powerful tail. Adult alligators generally have dark grey or nearly black color. They may at times appear to be lighter based on detritus or algae in the water covering their skin. Alligators eat fish, turtles, snakes, mammals, and amphibians. Hatchlings diet on invertebrates, insects, larvae, snails, spiders, worms, and other small prey. Young alligator regularly eat small fish at any opportunity.','https://vignette.wikia.nocookie.net/animals/images/0/03/American_Alligator.jpg/revision/latest?cb=20190101172010'),
    (DEFAULT,'Black Mamba','Reptile',2290,'USD','The black mamba (Dendroaspis polylepis) is a venomous snake endemicto parts of sub-Saharan Africa. Specimens vary in colour from grey to dark brown, but not black. Juvenile black mambas tend to be lighter in colour than adults and darken with age. It is the longest species of venomous snake indigenous to the African continent; mature specimens generally exceed 2 meters (6.6 ft) and commonly attain 3 meters (9.8 ft). Specimens of 4.3 to 4.5 meters (14.1 to 14.8 ft) have been reported.','https://vignette.wikia.nocookie.net/animals/images/c/cf/Black_Mamba.jpg/revision/latest?cb=20190101165636'),
    (DEFAULT,'Saltwater Crocodile','Reptile',31990,'USD','The Saltwater Crocodile is a specie from the Crocodylus genus. It is found in suitable habitats from Northern Australia through Southeast Asia to the eastern coast of India. Saltwater crocodiles are the largest extant riparian predators in the world. However, they start life fairly small. Newly hatched saltwater crocodiles measure about 28 cm (11 in) long and weigh an average of 71 g (2.5 oz). This distinct contrast in size between hatchlings and adult males is one of the greatest in terrestrial vertebrates. Males reach sexual maturity around 3.3 m (10 ft 10 in) at around 16 years of age, while females reach sexual maturity at 2.1 m (6 ft 11 in) and 12-14 years of age.','https://vignette.wikia.nocookie.net/animals/images/c/c1/Saltwater_Crocodile.jpg/revision/latest?cb=20180202031609'),
    (DEFAULT,'Panther chameleon','Reptile',1199,'USD','The panther chameleon (Furcifer pardalis) is a species of chameleon found in the eastern and northern parts of Madagascar in a tropical forest biome. Additionally, it has been introduced to Reunion and Mauritius. The panther chameleon was first described by French naturalist Georges Cuvier in 1829. Its generic name (Furcifer) is derived from the Latin root furci meaning "forked" and refers to the shape of the animal''s feet. The specific name pardalisrefers to the animals'' markings, as it is Latin for "leopard" or "spotted like a panther".  The English word chameleon (also chamaeleon) derives from Latin chamaeleo, a borrowing of the Ancient Greek (khamailéon), a compound of (khamaí) "on the ground" and (léon) "lion".','https://vignette.wikia.nocookie.net/animals/images/c/c1/Image-1459175441.jpeg/revision/latest?cb=20160328143041'),
    (DEFAULT,'King Cobra','Reptile',1990,'USD','The king cobra (Ophiophagus hannah) is an elapid found predominantly in forests from India through Southeast Asia. This species is the world''s longest venomous snake, with a length up to 18.5 to 18.8 ft (5.6 to 5.7 m). Despite the word "cobra" in its common name, this snake is not a member of the Naja genus ("true cobras"), which contains most cobra species, but the sole member of its own genus. It preys chiefly on other snakes and occasionally on some other vertebrates, such as lizards and rodents. The king cobra is a dangerous snake that has a fearsome reputation in its range, although it typically avoids confrontation with humans when possible.','https://vignette.wikia.nocookie.net/animals/images/9/9c/King_Cobra_Close.jpg/revision/latest?cb=20120525094332'),
    (DEFAULT,'Cape Melville Leaf-tailed Gecko','Reptile',99,'USD','The Cape Melville leaf-tailed gecko, (Saltuarius eximius), is a species of gecko that is endemic to the Melville Range on Cape Melville in Northern Australia. The species was described in 2013 by Australian zoologists Conrad Hoskin (of James Cook University) and Patrick Couper (curator of herpetology at Queensland Museum). The lizards are about 20 cm long and are believed to be a relic species from the time period rainforests were more abundant in Australia. The name derives from the Latin word for "extraordinary" or "exquisite", and refers to the lizard''s distinctive, camoflauged appearance. It hides among rocky boulders in the day and emerges at night to hunt on rocks and trees.','https://vignette.wikia.nocookie.net/animals/images/0/06/The_Cape_Melville_Leaf-tailed_Gecko_%28Saltuarius_eximius%29._Photo_by_Conrad_Hoskin.jpg/revision/latest?cb=20140423213111'),
    (DEFAULT,'Axolotl','Amphibian',99,'USD','The Axolotl is a specie from the Ambystoma genus. The species originates from Lake Xochimilco underlying Mexico City. Axolotls have feather-like external gills, and lidless eyes. They are closely related to Tiger salamanders, and many mistaken axolotls for Tiger Salamander larva Color Variations Axolotls of various colours occur in captivity, including grey, shades of brown, leucistic (white with black eyes), golden albino, white albino, as well as other varieties, such as the melanoid (a near-black animal). The normally coloured axolotl, the "wild type", can be near-black, or even creamy in colour, and anywhere in between.','https://vignette.wikia.nocookie.net/animals/images/3/39/Mexican_Axolotl.jpg/revision/latest?cb=20120530090251'),
    (DEFAULT,'Cream-backed Poison Frog','Amphibian',49,'USD','The Cream-backed Poison Frog is a specie from the Hyloxalus genus. It is endemic to Ecuador. The cream-backed poison frog is named for its back, which is cream-coloured in the males; this is the most notable difference between the sexes.','https://vignette.wikia.nocookie.net/animals/images/0/07/Hyloxalus.png/revision/latest?cb=20100731123857'),
    (DEFAULT,'Tiger Salamander','Amphibian',79,'USD','The Tiger Salamander is a specie from the Ambystoma genus. The species originates from numerous lakes, such as Lake Xochimilco underlying Mexico City. Thick-bodied amphibians with short snouts, sturdy legs, and long tails, tigers are the largest land-dwelling salamander on Earth. They can grow to 14 inches in length, but the average size is more like 6 to 8 inches. Highly voracious predators, they emerge from their burrows at night to feed on worms, insects, frogs, and even other salamanders. Their population is healthy throughout their range, but deforestation, pollution, and rising acidity levels in their breeding pools is affecting their distribution.','https://vignette.wikia.nocookie.net/animals/images/c/c8/Salamandra_Tigre.png/revision/latest?cb=20120530094118'),
    (DEFAULT,'Adelphobates galactonotus','Amphibian',129,'USD','Adelphobates galactonotus, also known as the splash-backed poison frog or splashback poison frog, is a species of frog in the Dendrobatidae family. It is endemic to the rainforest of the southern Amazon Basin in Brazil. Its natural habitats are tropical moist lowland forests and intermittent freshwater marshes. Though a common species, it is threatened by habitat loss.','https://vignette.wikia.nocookie.net/animals/images/b/b2/Adelphobates-galactonotus.jpg/revision/latest?cb=20150626050901'),
    (DEFAULT,'Bale Mountains Tree Frog','Amphibian',169,'USD','The Bale Mountains tree frog (Balebreviceps hillmani), is a species of frog in the Brevicipitidae family. It is monotypic within the genus Balebreviceps. It is endemic to the Bale Mountains of Ethiopia. Its natural habitats are tree heath (Erica arborea) woodlands near the timberline as well as partly cleared mixed forests further down. Despite its entire range being within the Bale Mountains National Park, it is threatened by habitat loss and deterioration (deforestation) caused by cattle grazing, firewood collection, fencing, and settlement development.','https://vignette.wikia.nocookie.net/animals/images/0/03/Male-Ethiopian-short-headed-frog.jpg/revision/latest?cb=20150622043022'),
    (DEFAULT,'Cape Rain Frog','Amphibian',99,'USD','The Cape rain frog or giant rain frog (Breviceps gibbosus), is a species of frog in the Brevicipitidae family. Krefft''s Warty Frog. It is endemic to South Africa, where it occurs in the far south-western Cape, in Cape Town and northwards as far as Citrusdal. In this area it inhabits Mediterranean-type shrubby vegetation, known as fynbos, renosterveld, pastureland on farms, rural gardens, and even urban areas. It seems to adapt well to suburban gardens, but like most frog species it is vulnerable to herbicide poisons and domestic pets.','https://vignette.wikia.nocookie.net/animals/images/1/1a/20110913durbanville-caperainfrog.jpg/revision/latest?cb=20150617222413'),
    (DEFAULT,'Desert Rain Frog','Amphibian',179,'USD','The Desert rain frog (Breviceps macrops), is a species of frog in the Brevicipitidae family. It is found in Namibia and South Africa. Its natural habitats are subtropical or tropical dry shrubland and sandy shores. It is threatened by habitat loss. The desert rain frog is a small, plump species with bulging eyes, a short snout, short limbs, spade-like feet and webbed toes. On the underside it has a transparent area of skin through which its internal organs can be seen. Its colour is yellowish-brown and it often has sand adhering to its skin.','https://vignette.wikia.nocookie.net/animals/images/4/47/Desert-rain-frog-walking.jpg/revision/latest?cb=20150618040240'),
    (DEFAULT,'Excidobates captivus','Amphibian',239,'USD','Excidobates captivus, also known as the Santiago poison frog or Rio Santiago poison frog, is a species of frog in the Dendrobatidae family. It is endemic to northwestern Peru and southern Ecuador. Its natural habitat is tropical moist lowland forests. This frog is black with rows of orange-red spots on its back and yellow spots underneath. With an adult snout-to-vent length of 15 to 17 mm (0.6 to 0.7 in), Excidobates captivus is a very small species of poison frog. It is black with orange-red splotches arranged in a row down either side of the back. It also has small yellow spots above the armpit and groin and further pale yellow spots beneath the chin and scattered on the chest and belly and under the thighs.','https://vignette.wikia.nocookie.net/animals/images/9/90/Captivus5.jpg/revision/latest?cb=20150627075858'),
    (DEFAULT,'Forest Rain Frog','Amphibian',29,'USD','The Forest rain frog (Breviceps sylvestris), is a species of frog in the Brevicipitidae family. It is endemic to Limpopo, South Africa. Two allopatric subspecies are recognized: the nominate one, Breviceps sylvestris sylvestris, and Breviceps sylvestris taeniatus from near Soutpansberg. Its natural habitats are temperate forests, temperate grassland, and rural gardens. It is threatened by habitat loss. Forest rain frogs can range in colour from red, orange, yellow, green, and purple. They can also vary in size from a mere 2cm and grow to be about 10cm in body length. The frogs are known to contain a defense mechanism consisting of a toxic chemical on their slimy exterior. If contact is made with this toxin the temporary effect of paralysis can occur.','https://vignette.wikia.nocookie.net/animals/images/3/33/Forest-rain-frog.jpg/revision/latest?cb=20150619050517'),
    (DEFAULT,'Golden Poison Frog','Amphibian',399,'USD','The golden frog is found only in isolated regions of Panama. It''s bright colour warns predators that it is toxic. Scientists believe that a major cause of its decline is climate change. During drought years, the frogs are forced into overcrowded wet areas, which lead to fatal diseases. The Golden poison frog (Phyllobates terribilis), also known as the golden frog, golden poison arrow frog, or golden dart frog, is a species of frog in the Dendrobatidae family. It is endemic to the Pacific coast of Colombia.','https://vignette.wikia.nocookie.net/animals/images/2/28/Golden-poison-frog-sitting-on-leaf.jpg/revision/latest?cb=20150701043049'),
    (DEFAULT,'Kihansi Spray Toad','Amphibian',149,'USD','The Kihansi spray toad (Nectophrynoides asperginis), is a species of toad in the Bufonidae family. Females reaching up to 2.9 cm (1.1 in) long and males up to 1.9 cm (0.75 in). This ovoviviparous species was scientifically described in 1999. It was found only in the spray zone around the Kihansi waterfalls in the southern Udzungwa Mountains in Tanzania. At about 20,000 m2 (220,000 sq ft), this was one of the smallest natural distribution known for any vertebrate species, Following the construction of the Kihansi Dam, it became extinct in the wild.','https://vignette.wikia.nocookie.net/animals/images/d/d0/2145.jpeg/revision/latest?cb=20150508024143'),
    (DEFAULT,'Yellow-bellied Poison Frog','Amphibian',239,'USD','The Yellow-bellied poison frog (Andinobates fulguritus), also known as the yellow-bellied poison-arrow frog or yellowbelly poison frog, is a species of frog in the Dendrobatidae family. It is endemic to northwestern Colombia and east-central Panama. Its natural habitats are tropical moist lowland forests. It is a locally common, terrestrial frog. The eggs are deposited in leaf-litter; both parents carry the tadpoles to leaf axils, usually bromeliads, where they complete their development. It is threatened by habitat loss and pollution. This species seems not to be collected for pet trade.','https://vignette.wikia.nocookie.net/animals/images/f/f9/6819263362_b66923d65a_b.jpg/revision/latest?cb=20150702233228');
