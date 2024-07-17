document.addEventListener('DOMContentLoaded', () => {
	let diceChartInstance;

	function rollDice(numSides, numDice) {
		let sum = 0;
		for (let i = 0; i < numDice; i++) {
			sum += Math.floor(Math.random() * numSides) + 1;
		}
		return sum;
	}

	function simulateDiceRolls() {
		const numSides = parseInt(document.getElementById('numSides').value);
		const numDice = parseInt(document.getElementById('numDice').value);
		const numRolls = parseInt(document.getElementById('numRolls').value);
		const results = {};

		for (let i = 0; i < numRolls; i++) {
			const sum = rollDice(numSides, numDice);
			if (results[sum]) {
				results[sum]++;
			} else {
				results[sum] = 1;
			}
		}

		const probabilities = {};
		for (let sum in results) {
			probabilities[sum] = results[sum] / numRolls;
		}

		displayResults(probabilities);
	}

	function displayResults(probabilities) {
		const labels = Object.keys(probabilities).map(Number);
		const data = Object.values(probabilities);

		const chartData = {
			labels: labels,
			datasets: [{
				label: 'Probability Distribution',
				data: data,
				backgroundColor: '#8EAD7D'
			}]
		};

		const config = {
			type: 'bar',
			data: chartData
		};

		const diceChartElement = document.getElementById('diceChart');
		if (diceChartInstance) {
			diceChartInstance.destroy();
		}
		diceChartElement.style.display = 'block';
		diceChartInstance = new Chart(diceChartElement, config);
	}

	// call from html
	window.simulateDiceRolls = simulateDiceRolls;
});
