basics :-
    write('what\'s your name?'),
    read(N), nl,
    write('how old are you?'),
    read(A), nl,
    write('what\'s your weight (in kilos)?'),
    read(W), nl,
    write('what\'s your height (in meters)?'),
    read(H), nl,
    write('last blood pressure?'),
    read(B), nl,
    write('Hi '),
    write(N),
    write('!'),nl,
    write('basic information: '), nl,nl,
    write('age: '),
    write(A), nl,
    write('weight (in kilos): '),
    write(W), nl,
    write('height (in meters): '),
    write(H), nl,
    write('blood pressure: '),
    write(B), nl.

diagnosis:-
    write('Hello!'),nl,
    write('I am Baymax.'),nl,
    write('Your personal healthcare companion.'),nl,
    basics,
    hypothesis(Disease),
    write(Disease),
    write(' detected.'), nl,
    write('Take Care!'),
    undo.

hypothesis(influenza) :- influenza, !.
hypothesis(acute_tonsillopharyngitis) :- acute_tonsillopharyngitis, !.
hypothesis(chickenpox) :- chickenpox, !.
hypothesis(undernutrition) :- undernutrition, !.
hypothesis(sore_eyes) :- sore_eyes, !.
hypothesis(acute_diarrhea) :- acute_diarrhea, !.
hypothesis(scabies) :- scabies, !.
hypothesis(hepatitis_A) :- hepatitis_A, !.
hypothesis(hypertension) :- hypertension, !.
hypothesis(leptospirosis) :- leptospirosis, !.
hypothesis(cholera) :- cholera, !.
hypothesis(meningitis) :- meningitis, !.
hypothesis(tuberculosis) :- tuberculosis, !.
hypothesis(pneumonia) :- pneumonia, !.
hypothesis(dengue_fever) :- dengue_fever, !.    
hypothesis(unknown) :-
    write('Your illness is unknown in our database, please go to the nearest medical facility for further diagnosis.').


influenza :-
    write('certainty level at 0%'), nl,
    symptom(lethargic),
    write('certainty level at 30%'),nl,
    symptom(watery_eyes),
    write('certainty level at 50%'),nl,
    symptom(headache),
    write('certainty level at 60%'),nl,
    symptom(fever),
    write('you have influenza with certainty level of 70%'), nl,
    write('Treatment for Influenza: '), nl,
    write('Annual Influenza vaccination: '),nl,
    write('Rehydrate'),nl, 
    write('Antibiotics'),nl.

acute_tonsillopharyngitis :-
    write('certainty level at 0%'), nl,
    symptom(sore_throat),
    write('certainty level at 30%'),nl,
    symptom(swollen_tonsils),
    write('certainty level at 60%'),nl,
    symptom(bad_breath),
    write('certainty level at 70%'),nl,
    symptom(fever),
    write('you have acute tonsillopharyngitis with certainty level at 80%'), nl,
    write('Treatment for Acute tonsillopharyngitis: '),nl,
    write('Antibiotics'),nl,
    write('Penicillin V: 250mg 2 times a day for 10 days for kg < 27 and 500 mg for kg>27'),nl,
    write('Rest'),nl.

chickenpox :-
    write('certainty level at 0%'), nl,
    symptomPic(red_spots),
    write('certainty level at 30%'),nl,
    symptomPic(blister),
    write('certainty level at 60%'),nl,
    symptom(fever),
    write('certainty level at 70%'),nl,
    symptom(itchiness),
    write('you have chickenpox with certainty level at 80%'), nl,
    write('Treatment for Varicella/Chicken pox (relieving the itch): '),nl,
    write('Antihistamines'),nl,
    write('Rest at home; Avoid infecting others'),nl,
    write('Use small cloth to pat itchy parts'),nl.

undernutrition :-
    write('certainty level at 0%'), nl,
    symptom(low_body_weight), /*note: paiba once maimplement yung pagkuha weight and stuff.*/
	write('certainty level at 30%'), nl,
    symptom(low_appetite),
    write('certainty level at 40%'), nl,
    symptom(pale_skin),
    write('certainty level at 50%'), nl,
    symptomPic(sparse_hair),
    write('you have undernutrition with certainty level at 60%'), nl,
    write('Treatment for Undernutrition: '),nl,
    write('Intravenous feeding'),nl,
    write('Drugs to increase appetite: Dronabinol or Megestrol'),nl,
    write('Multivitamins'),nl.

sore_eyes :-
    write('certainty level at 0%'), nl,
    symptomPic(eye_redness),
    write('certainty level at 30%'), nl,
    symptom(itchy_eyes),
    write('certainty level at 40%'), nl,
    symptom(blurred_vision),
    write('certainty level at 50%'), nl,
    symptomPic(puffy_eyes),
    write('you have sore eyes with certainty level at 60%'), nl,
    write('Treatment for Allergic Conjunctivitis/Sore eyes: '),nl,
    write('Eye drops'),nl,
    write('Use water to wash eyes'),nl,
    write('Antihistamines'),nl.

acute_diarrhea :-
    write('certainty level at 0%'), nl,
    symptomPic(watery_stool),
    write('certainty level at 30%'), nl,
    symptom(dehydration),
    write('certainty level at 40%'), nl,
    symptom(fever),
    write('certainty level at 50%'), nl,
    symptomPic(paleness),
    write('you have acute diarrhea with certainty level at 60%'), nl,
    write('Treatment for Acute diarrhea: '),nl,
    write('Extra fluids to maintain electrolytes'),nl,
    write('Appropriate diet'),nl.

scabies :-
    write('certainty level at 0%'), nl,
    symptomPic(mite_burrow),
    write('certainty level at 40%'), nl,
    symptom(red_bumps),
    write('certainty level at 50%'), nl,
    symptomPic(rash),
    write('you have scabies with certainty level at 60%'), nl,
    write('Treatment for Scabies: '),nl,
    write('Apply lindane lotion to entire body and washing it after 8 to 14 hours. Repeat a week later.'),nl.
    

hepatitis_A :-
    write('certainty level at 0%'), nl,
    symptomPic(dark_urine),
    write('certainty level at 20%'), nl,
    symptomPic(jaundice),
    write('certainty level at 40%'), nl,
    symptom(fatigue),
    write('certainty level at 50%'), nl,
    symptom(fever),
    write('certainty level at 60%'), nl,
    symptom(nausea),
    write('based on our database, you may have hepatitis A with certainty level at 70%'), nl,
    write('more medical tests are needed. suggestion: blood test'),nl,
    write('Treatment for Hepatitis A: '),nl,
    write('Vaccination'),nl,
    write('If itching: take cholestyramine'),nl,
    write('Maintain good hygiene'),nl,
    write('for definite diagnosis, proceed to the nearest hospital'),nl.

hypertension :-
    write('certainty level at 0%'), nl,
    symptom(high_blood_pressure),
    write('certainty level at 40%'), nl,
    symptom(fatigue),
    write('certainty level at 50%'), nl,
    symptom(dizziness),
    write('you have hypertension with certainty level at 60%'), nl,
    write('Treatment for Hypertension: '),nl,
    write('Regular exercise and healthy diet'),nl,
    write('Multivitamins '),nl.

leptospirosis :-
    write('certainty level at 0%'), nl,
    symptom(muscle_pain), 
    write('certainty level at 20%'), nl,
    symptomPic(jaundice),
    write('certainty level at 40%'), nl,
    symptom(fever),
    write('certainty level at 50%'), nl,
    symptom(fatigue),
    write('certainty level at 60%'), nl,
    symptom(nausea),
    write('according to our database, you may have leptospirosis with certainty level at 70%'), nl,
    write('Treatment for Leptospirosis'),nl,
    write('Antibiotics (Penicillin or ampicillin'),nl,
    write('Rest'),nl,
    write('for definite diagnosis, proceed to the nearest hospital'),nl.

cholera :-
    write('certainty level at 0%'), nl,
    symptom(low_blood_pressure),
    write('certainty level at 30%'),
    symptom(muscle_cramps),
    write('certainty level at 60%'),
    symptom(dehydration),
    write('certainty level at 70%'),
    symptomPic(watery_stools),
    write('you have cholera with certainty level at 80%'), nl,
    write('Treatment for Cholera: '),nl,
    write('Antibiotics'),nl,
    write('Vaccination'),nl,
    write('Maintain clean environment to avoid bacteria '),nl.

meningitis :-
    write('certainty level at 0%'), nl,
    symptomPic(reddish_purple_dots),
    write('certainty level at 20%'), nl,
    symptom(high_fever),
    write('certainty level at 30%'), nl,
    symptom(dizziness),
    write('certainty level at 40%'), nl,
    symptom(vomiting),
    write('certainty level at 50%'), nl,
    symptom(lethargy),
    write('you have meningitis with certainty level at 60%'), nl,
    write('Treatment for Meningitis: '),nl,
    write('Antibiotics and Vaccination'),nl,
    write('Dexamethasone'),nl,
    write('Antiseizure drugs'),nl.

tuberculosis :-
    write('certainty level at 0%'), nl,
    symptom(coughing_blood),
    write('certainty level at 30%'), nl,
    symptom(fever),
    write('certainty level at 40%'), nl,
    symptom(night_sweats),
    write('certainty level at 50%'), nl,
    symptom('chest_pain'),
    write('you have tuberculosis with certainty level at 60%'), nl,
    write('Treatment for Active Tuberculosis'),nl,
    write('Cover mouth when coughing to avoid spreading disease. '),nl,
    write('Rest at home'),nl.

pneumonia :-
    write('certainty level at 0%'), nl,
    symptomPic(thick_mucus),
    write('certainty level at 30%'), nl,
    symptom(shortness_of_breath),
    write('certainty level at 40%'), nl,
    symptom(fever),
    write('certainty level at 50%'), nl,
    symptom(chills),
    write('you have pneumonia with certainty level at 60%'), nl,
    write('more medical tests are needed. suggestion: X-ray'), nl,
    write('Treatment for Pneumonia: '),nl,
    write('Antibiotics'),nl,
    write('Antiviral and antifungal drugs'),nl,
    write('Rest at home to avoid spreading disease. '),nl.

dengue_fever :-
    write('certainty level at 0%'), nl,
    symptom(high_fever),
    write('certainty level at 10%'), nl,
    symptom(fatigue),
    write('certainty level at 20%'), nl,
    symptom(vomiting),
    write('certainty level at 30%'), nl,
    symptom(nausea),
    write('certainty level at 40%'), nl,
    symptom(muscle_pain),
    write('you have dengue fever with certainty level at 50%'), nl,
    write('more medical tests are needed. suggestion: blood sample'), nl,
    write('Treatment for Dengue Fever'),nl,
    write('Acetaminophen: lessen pain and lower fever'),nl,
    write('IV fluids'),nl,
    write('Rest at home and take pain relievers'),nl.

ask(Question) :-
    write('Does the patient have following symptom:'),
    write(Question),
    write('? '),
    read(Response),
    nl,
    ( (Response == yes ; Response == y)
    ->
    assert(yes(Question)) ;
    assert(no(Question)), fail).

askPic(Question) :-
    write('Does the patient have '),
    write(Question),
    write(' as seen on the pic? '),
    read(Response),
    nl,
    ( (Response == yes ; Response == y)
    ->
    assert(yes(Question)) ;
    assert(no(Question)), fail).

:- dyanmic yes/1,no/1.

/*How to verify something */
symptom(S) :-
    (yes(S)
    ->
    true ;
    (no(S)
    ->
    fail ;
    ask(S))).

symptomPic(S) :-
    (yes(S)
    ->
    true ;
    (no(S)
    ->
    fail ;
    askPic(S))).

/* undo all yes/no assertions*/
undo :- retract(yes(_)),fail.
undo :- retract(no(_)),fail.
undo.