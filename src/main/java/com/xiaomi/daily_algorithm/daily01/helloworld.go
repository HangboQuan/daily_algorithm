package main

import "fmt"

func main() {
	fmt.Printf("hello, world")
	traversalString()
}

func traversalString() {
	s := "alibaba is happy boy"
	for i := 0; i < len(s); i++ {
		fmt.Printf("%v(%c)", s[i], s[i])
	}
}
