// This grammar is strongly inspired from PlantUML's object and class diagram synthaxes.

grammar JustificationDiagram;

/*
 * Parser Rules
 */

diagram:
    START
    (title=TITLE)?
    (fragmentDeclaration | justificationDeclaration)*
    weavingDirective*
    END
    EOF;

fragmentDeclaration:
    'fragment' label=STRING 'as' ALIAS '{'
    instruction*
    '}';

justificationDeclaration:
    'justification' label=STRING 'as' ALIAS '{'
    instruction*
    '}';

weavingDirective:
    'weave' ALIAS 'into' ALIAS ('with' ALIAS '=' ALIAS)?;

instruction:
    declaration |
    relation;

declaration:
    element |
    conclusion;

element:
    TYPE ALIAS '=' label=STRING;

conclusion:
    'conclusion' ALIAS '=' label=STRING ('-' restriction=STRING)?;

relation:
    ALIAS LINK ALIAS;


/*
 * Lexer Rules
 */

WHITESPACE: (' ' | '\t')+ -> skip;
NEWLINE:  ('\r'? '\n' | '\r')+ -> skip;

START: '@startuml';
END: '@enduml';

TITLE: 'title ' ('A'..'Z' | 'a'..'z' | '1'..'9' | ' ')+ '\n';

TYPE: ('subconclusion' | 'strategy' | 'rationale' | 'domain' | 'support');
ALIAS: ('A'..'Z' | 'a'..'z' | '1'..'9')+;
LINK: ('-->' | '..>');


