document.addEventListener('DOMContentLoaded', () => {
	let coinTossChartInstance;
	let dieRollChartInstance;
	let cardDrawChartInstance;
	let twoCoinTossChartInstance;


	// #1 - Simulating Coin Tosses
	function simulateCoinTosses() {
		let heads = 0;
		let tails = 0;

		for (let i = 0; i < 100; i++) {
			if (Math.random() < 0.5) {
				heads++;
			} else {
				tails++;
			}
		}

		const data = {
			labels: ['Heads', 'Tails'],
			datasets: [{
				label: 'Coin Toss Results',
				data: [heads, tails],
				backgroundColor: ['#4caf50', '#f44336']
			}]
		};

		const config = {
			type: 'bar',
			data: data
		};

		const coinTossChartElement = document.getElementById('coinTossChart');
		if (coinTossChartInstance) {
			coinTossChartInstance.destroy();
		}
		coinTossChartElement.style.display = 'block'; // Show the chart
		coinTossChartInstance = new Chart(coinTossChartElement, config);
	}


	// #2 - Rolling a Die
	function simulateDieRolls() {
		const outcomes = [0, 0, 0, 0, 0, 0];

		for (let i = 0; i < 60; i++) {
			const roll = Math.floor(Math.random() * 6);
			outcomes[roll]++;
		}

		const data = {
			labels: ['1', '2', '3', '4', '5', '6'],
			datasets: [{
				label: 'Die Roll Results',
				data: outcomes,
				backgroundColor: ['#ff6384', '#36a2eb', '#cc65fe', '#ffce56', '#4bc0c0', '#9966ff']
			}]
		};

		const config = {
			type: 'bar',
			data: data
		};

		const dieRollChartElement = document.getElementById('dieRollChart');
		if (dieRollChartInstance) {
			dieRollChartInstance.destroy();
		}
		dieRollChartElement.style.display = 'block'; // Show the chart
		dieRollChartInstance = new Chart(dieRollChartElement, config);
	}

	// #3 - Drawing Cards
	function simulateDrawingCards() {
		let redCount = 0;
		let blackCount = 0;

		for (let i = 0; i < 20; i++) {
			if (Math.random() < 0.5) {
				redCount++;
			} else {
				blackCount++;
			}
		}

		const data = {
			labels: ['Red', 'Black'],
			datasets: [{
				label: 'Card Draw Results',
				data: [redCount, blackCount],
				backgroundColor: ['#ff6384', '#36a2eb']
			}]
		};

		const config = {
			type: 'bar',
			data: data
		};

		const cardDrawChartElement = document.getElementById('cardDrawChart');
		if (cardDrawChartInstance) {
			cardDrawChartInstance.destroy();
		}
		cardDrawChartElement.style.display = 'block'; // Show the chart
		cardDrawChartInstance = new Chart(cardDrawChartElement, config);
	}

	// #4 - Probability of Compound Events
	function simulateTwoCoinTosses() {
		let bothHeads = 0;
		let atLeastOneHead = 0;

		for (let i = 0; i < 50; i++) {
			const toss1 = Math.random() < 0.5;
			const toss2 = Math.random() < 0.5;

			if (toss1 && toss2) {
				bothHeads++;
			}
			if (toss1 || toss2) {
				atLeastOneHead++;
			}
		}

		const data = {
			labels: ['Both Heads', 'At Least One Head'],
			datasets: [{
				label: 'Two Coin Toss Results',
				data: [bothHeads, atLeastOneHead],
				backgroundColor: ['#4caf50', '#ff9800']
			}]
		};

		const config = {
			type: 'bar',
			data: data
		};

		const twoCoinTossChartElement = document.getElementById('twoCoinTossChart');
		if (twoCoinTossChartInstance) {
			twoCoinTossChartInstance.destroy();
		}
		twoCoinTossChartElement.style.display = 'block'; // Show the chart
		twoCoinTossChartInstance = new Chart(twoCoinTossChartElement, config);
	}


	window.simulateCoinTosses = simulateCoinTosses;
	window.simulateDieRolls = simulateDieRolls;
	window.simulateDrawingCards = simulateDrawingCards;
	window.simulateTwoCoinTosses = simulateTwoCoinTosses;
});