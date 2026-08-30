Plan if you want me to implement:

     1. New ErrorLexico (unchecked) with lexema + nroDeLinea fields in org.        
        example.analizadorlexico.              


     2. Track lexeme start line in AnalizadorLexico (in proximoToken()).           
     3. Replace every throw new RuntimeException(...) in the lexer with throw      
        new ErrorLexico(...) using the accumulated lexema and start line.          
     4. Make e0()'s else branch throw on invalid chars; add EOF checks in block-   
        comment states.                                                            
     5. Catch ErrorLexico in Main, print [Error:<lexema>|<nroDeLinea>], and        
        don't print [SinErrores].                                                  
     6. Verify with ./gradlew test.  