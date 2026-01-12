const stripe = Stripe('pk_test_51SiWmJK2464HLMKYQ8pp0JB393zbkHpQX5qiMl9edNJsIUSDymsIt2q44MQ0hpPHOeBwpKokKoorrlc0RixEYxNi00zUnDtEZE');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', async () => {
  console.log("sessionId in stripe.js:", sessionId);

  if (!sessionId || typeof sessionId !== "string") {
    alert("sessionIdが取得できていません（null/undefined）。サーバーから渡せているか確認してください。");
    return;
  }

  const { error } = await stripe.redirectToCheckout({ sessionId });
  if (error) {
    console.error("Stripe redirectToCheckout error:", error);
    alert(error.message);
  }
});
