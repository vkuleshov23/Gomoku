#include<iostream>

int main(){
	int size = 15; 
	int mass[size][size];

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			mass[i][j] = 0;
		}
	}

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			std::cout << mass[i][j] << ' ';
		}
		std::cout << '\n';
	}
		std::cout << '\n';




	// WORKING
	for(int length = 4, counter = 1; length < size; length++){
		for(int j = 0, i = length; j <= length; j++, i--){
			mass[i][j] = counter;
		}
		counter++;
	}



	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			std::cout << mass[i][j] << ' ';
		}
		std::cout << '\n';
	}
		std::cout << '\n';

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			mass[i][j] = 0;
		}
	}
	
	// WORKING
	for (int length = size, counter = 1; length > 4; length--, counter++){
		for(int j = 0, i = counter-1; j < length; j++, i++){
			mass[i][j] = counter;
		}
	}

	

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			std::cout << mass[i][j] << ' ';
		}
		std::cout << '\n';
	}
		std::cout << '\n';

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			mass[i][j] = 0;
		}
	}

	// WORKING
	for(int length = size-1, counter = 1; length > 4; length--, counter++){
		for(int j = counter , i = size-1, k = 0; (k < length); j++, k++){
	 		mass[i-k][j] = counter;
		}
	}

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			std::cout << mass[i][j] << ' ';
		}
		std::cout << '\n';
	}
		std::cout << '\n';

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			mass[i][j] = 0;
		}
	}

	// WORKING
	for(int length = size-1, counter = 1; length > 4; length--, counter++){
		for(int j = counter, i = 0, k = 0; k < length; j++, k++){
			mass[i+k][j] = counter;
		}
	}

	for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){	
			std::cout << mass[i][j] << ' ';
		}
		std::cout << '\n';
	}
}