package net.mips.compiler;

public class ErreurLexicale extends ErreurCompilation 
{
	CodesErr message;

	ErreurLexicale(CodesErr code)
	{
	   super(code.getMessage());
	}

}
