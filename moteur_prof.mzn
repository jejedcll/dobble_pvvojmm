include "globals.mzn";

int: NC;
int: NS;
int: NSC;
int: NV;

var int: Max_Symb = ((NC*NSC) div NS) + 2;
var int: Max_Variantes = ((NC * NSC) div NV) + 2;
var int: Max_Variantes_per_card = (NSC div NV) + 1;

set of int: CARTES = 1..NC;
set of int: SYMBOLES = 1..NS;
set of int: SYMB_CARTES = 1..NSC;
set of int: VARIANTES = 1..NV;
set of int: SYMUTIL = 1..NC*NSC;

array[CARTES, SYMB_CARTES] of var SYMBOLES: jeu_symb;
array[CARTES, SYMB_CARTES] of var VARIANTES: jeu_var;
array[SYMBOLES] of var int: nb_symb; %nb_symb = nombre d'occurence du symbole i
array[VARIANTES] of var int: nb_var; %nb_var[i] = nombre d'occurence de la variantes i

%contraintes symboles différents par carte
constraint forall(c in CARTES)(alldifferent([jeu_symb[c,s] | s in SYMB_CARTES]));

%constraites order par carte -> pour accélerer la résolution
constraint forall(c in CARTES)(increasing([jeu_symb[c,s]|s in SYMB_CARTES]));

%contrainte un symbole commun entre deux cartes
constraint forall(c, cc in CARTES where (c <cc))
  (sum(s in SYMB_CARTES)
    (sum(ss in SYMB_CARTES)
      (bool2int(jeu_symb[c,s] = jeu_symb[cc, ss]))) = 1);

%meilleure répartition des symboles
constraint forall(s in SYMBOLES)(nb_symb[s] <= Max_Symb);


%somme pour chaque symboles
constraint forall(s in SYMBOLES)(sum(c in CARTES, ss in SYMB_CARTES)(bool2int(jeu_symb[c,ss]=s))=nb_symb[s]);

%somme pour chaque variantes dans tous le jeu
constraint forall(v in VARIANTES)(sum(c in CARTES, sc in SYMB_CARTES)(bool2int(jeu_var[c, sc]=v))=nb_var[v]);

constraint forall(c in CARTES)(increasing([jeu_var[c, v]| v in VARIANTES]));

constraint forall(v in VARIANTES)(nb_var[v] <= Max_Variantes);

constraint forall(c in CARTES, v in VARIANTES)(sum(s in SYMB_CARTES)(bool2int(jeu_var[c, s] = v)) <= Max_Variantes_per_card);

%eRépartition égale des variantes

% Fixe première valeur pour accélérer la propagation
constraint jeu_symb[1,1] = 1;
constraint jeu_var[1,1] = 1;

solve satisfy;

%output [if j == 1 then "c" ++ show(i) else "" endif ++ "\t" 
 %       ++ show(jeu_symb[i, j]) 
  %      ++ if j == NSC then "\n" else "" endif  
   %     | i in CARTES, j in SYMB_CARTES]
    %   ++ ["\n", show(nb_symb)]

output
  ["{\n  \"nc\":", show(NC), ",\n  \"ns\":", show(NS), ",\n  \"nsc\":", show(NSC), ",\n  \"nv\":", show(NV),
  ",\n  \"cards_symbols\": [\n"]
  ++ [ if s = 1 then "    {\n      \"id\":" ++ show(c) ++ ",\n"
        ++ "      \"symbols\": [" else "," endif
        ++ show(jeu_symb[c, s]) ++ if s = NSC then "]\n    }" ++ if c = NC then "\n" else ",\n" endif else "" endif
  | c in CARTES, s in SYMB_CARTES]
  ++ ["  ],\n  \"cards_variantes\": [\n"]
  ++ [ if s = 1 then "    {\n" 
        ++ "      \"id\":" ++ show(c) ++ ",\n"
        ++ "      \"variantes\": [" 
      else "," 
      endif
      ++ show(jeu_var[c, s]) 
      ++ if s = NSC 
         then "]\n    }" ++ 
           if c = NC then "\n" else ",\n" endif 
         else "" 
         endif
  | c in CARTES, s in SYMB_CARTES]
  ++ ["  ]\n}"]%output
%  ["{\n  \"nc\":", show(NC), ",\n  \"ns\":", show(NS), ",\n  \"nsc\":", show(NSC), ",\n  \"nv\":", show(NV)] 
%  ++ [",\n  \"deck\" : [\n"]  %toutes les cartes
%  ++ [if s = 1 then "    {\n      \"id\":" ++ show(c) ++ 
%      ",\n      \"symbols\": [\n" else ",\n" endif 
%      ++ "        { \"id\": " ++ show(jeu_symb[c, s]) ++ ",\"var\": " ++ show(jeu_var[c, s]) ++ "}" 
%      ++ if s = NSC then "\n      ]\n    }" ++ if c = NC then "\n" else ",\n" endif else "" endif
%      | c in CARTES, s in SYMB_CARTES] 
%  ++ ["  ]\n}"]